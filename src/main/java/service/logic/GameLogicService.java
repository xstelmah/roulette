package service.logic;

import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.dao.BalanceService;
import service.dao.GameService;
import service.dao.ItemService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service("gameLogicService")
public class GameLogicService {

    private static final Logger LOG = LoggerFactory.getLogger(GameLogicService.class);

    // win item number
    private static final Integer ITEM_LOAD_COUNT = 33;

    private static final Integer ITEM_WIN_NUMBER = 29;

    @Autowired
    private ItemService itemService;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private GameService gameService;

    public Item getFreeItemByRarity(ItemRarity rarity) {
        return itemService.getFreeItemByRarity(rarity);
    }

    public List<Chance> getChancesByRarity(ItemRarity rarity) {
        List<Chance> chances = new ArrayList<>();
        chances.add(new Chance(0.4f, ItemRarity.COMMON));
        chances.add(new Chance(0.1f, ItemRarity.UNCOMMON));
        chances.add(new Chance(0.1f, ItemRarity.RARE));
        chances.add(new Chance(0.1f, ItemRarity.MYTHICAL));
        chances.add(new Chance(0.1f, ItemRarity.IMMORTAL));
        chances.add(new Chance(0.1f, ItemRarity.LEGENDARY));
        chances.add(new Chance(0.1f, ItemRarity.IMMORTAL));
        return chances;
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

    public List<Item> play(User user, Bet bet) {
        if (user == null) {
            LOG.error("Game started, user is null");
            return null;
        }
        LOG.info("Game started, user id: " + user.getId());
        if (bet == null) {
            LOG.error("bet is null");
            return null;
        }
        Game game = new Game();
        game.setStartTime(new Date(System.currentTimeMillis()));
        Balance balance = balanceService.getBalanceByUserId(user.getId());
        if (balance == null) {
            LOG.error("Balance not loaded, lazy load not working");
            return null;
        }
        if (balance.getValue() < bet.getValue()) {
            LOG.warn("Not enought gold on bet balance: '" + balance.getValue() + "' bet: '" + bet.getValue() + "'");
            return null;
        }

        List<Chance> chances = getChancesByRarity(bet.getRarity());
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


}
