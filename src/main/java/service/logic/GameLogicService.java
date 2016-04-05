package service.logic;

import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.dao.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service("gameLogicService")
public class GameLogicService {

    private static final Logger LOG = LoggerFactory.getLogger(GameLogicService.class);

    // total count item
    private static final Integer ITEM_LOAD_COUNT = 33;
    // win item number
    private static final Integer ITEM_WIN_NUMBER = 29;

    @Autowired
    private ItemService itemService;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private GameService gameService;

    @Autowired
    private BetService betService;

    @Autowired
    private ChanceService chanceService;

    public Item getFreeItemByRarity(ItemRarity rarity) {
        return itemService.getFreeItemByRarity(rarity);
    }

    public List<Chance> getChancesByBet(Bet bet) {
        return chanceService.getChancesByBetId(bet.getId());
    }

    public Item getItemByChances(List<Chance> chances) {
        Double startChance = 0.0;
        Double rand = Math.random();
        ItemRarity winItemRarity = null;
        for (Chance chance : chances) {
            startChance += chance.getValue();
            if (rand <= startChance) {
                winItemRarity = chance.getRarity();
                break;
            }
        }
        if (winItemRarity == null) {
            LOG.error("Something wrong with Chances");
            return null;
        }
        Item winItem = getFreeItemByRarity(winItemRarity);
        if (winItem == null) {
            LOG.error("Not found clear item rarity: " + winItemRarity.toString());
            return null;
        }
        return winItem;
    }

    public List<Item> playOnMoney(User user, Bet bet) {
        if (user == null) {
            LOG.error("Game started, user is null");
            return null;
        }
        LOG.info("Game started, user id: " + user.getId());
        if (bet == null || bet.getId() == null) {
            LOG.error("bet is null");
            return null;
        }
        bet = betService.getBetById(bet.getId());
        Game game = new Game();
        game.setTime(new Date(System.currentTimeMillis()));
        Balance balance = balanceService.getBalanceByUserId(user.getId());
        if (balance == null) {
            LOG.error("Balance not loaded, lazy load not working");
            return null;
        }
        if (balance.getValue() < bet.getValue()) {
            LOG.warn("Not enought gold on bet balance: '" + balance.getValue() + "' bet: '" + bet.getValue() + "'");
            return null;
        }

        List<Chance> chances = getChancesByBet(bet);
        Item winItem = getItemByChances(chances);

        if (winItem == null) {
            LOG.error("NOT FOUND WIN ITEM WITH RARITY " + bet.getRarity());
            return null;
        }
        List<Item> items = new ArrayList<>();

        balance.setValue(balance.getValue() - bet.getValue());
        balanceService.updateBalance(balance);

        game.setUser(user);
        game.setBet(bet.getValue());
        game.setDescription(winItem.getName());
        game.setNumber(-1);
        gameService.insertGame(game);
        game.setNumber(game.getId());
        gameService.updateGame(game);

        winItem.setGame(game);
        winItem.setUser(user);
        itemService.updateItem(winItem);
        for (int index = 0; index <= ITEM_LOAD_COUNT; index++) {
            if (ITEM_WIN_NUMBER == index) items.add(winItem);
            else items.add(getItemByChances(chances));
        }
        LOG.info("User: " + user.getId() + " win item rarity: " + winItem.getRarity());
        return items;
    }

    public List<Item> playFree(Bet bet) {
        if (bet == null || bet.getId() == null) {
            LOG.error("bet is null");
            return null;
        }
        bet = betService.getBetById(bet.getId());
        Game game = new Game();
        List<Chance> chances = getChancesByBet(bet);
        Item winItem = getItemByChances(chances);

        if (winItem == null) {
            LOG.error("NOT FOUND WIN ITEM WITH RARITY " + bet.getRarity());
            return null;
        }
        List<Item> items = new ArrayList<>();

        for (int index = 0; index <= ITEM_LOAD_COUNT; index++) {
            if (ITEM_WIN_NUMBER == index) items.add(winItem);
            else items.add(getItemByChances(chances));
        }
        LOG.info("Guest user win item with rarity: " + winItem.getRarity());
        return items;
    }

    public List<Bet> getBets(GameType gameType) {
        return betService.getBetsByGameType(gameType);
    }


}
