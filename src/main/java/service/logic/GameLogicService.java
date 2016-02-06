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

    @Autowired
    private ItemService itemService;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private GameService gameService;

    // getFreeItemByRarity
    public Item getFreeItemByRarity(ItemRarity rarity) {
        return itemService.getFreeItemByRarity(rarity.toString().toLowerCase());
    }

    public List<ExternalChance> getChancesByRarity(ItemRarity rarity) {
        List<ExternalChance> chances = new ArrayList<>();
        chances.add(new ExternalChance(0.4, ItemRarity.COMMON));
        chances.add(new ExternalChance(0.1, ItemRarity.UNCOMMON));
        chances.add(new ExternalChance(0.1, ItemRarity.RARE));
        chances.add(new ExternalChance(0.1, ItemRarity.MYTHICAL));
        chances.add(new ExternalChance(0.1, ItemRarity.IMMORTAL));
        chances.add(new ExternalChance(0.1, ItemRarity.LEGENDARY));
        chances.add(new ExternalChance(0.1, ItemRarity.IMMORTAL));
        return chances;
    }

    public String play(User user, ExternalBet bet) {
        if (user == null) {
            LOG.error("Game started, user is null");
            return "User is null";
        }
        LOG.info("Game started, user id: " + user.getId());
        if (bet == null) {
            LOG.error("bet is null");
            return "Bet is null";
        }
        Game game = new Game();
        game.setStartTime(new Date(System.currentTimeMillis()));
        Balance balance = balanceService.getBalanceByUserId(user.getId());
        if (balance == null) {
            LOG.error("Balance not loaded, lazy load not working");
            return "Balance not loaded, lazy load not working";
        }
        if (balance.getValue() <= bet.getBetValue()) {
            LOG.warn("Not enought gold on bet balance: '" + balance.getValue() + "' bet: '" + bet.getBetValue() + "'");
            return "Not enought gold on bet";
        }
        Double startChance = 0.0;
        List<ExternalChance> chances = getChancesByRarity(bet.getItemRarity());
        Double rand = Math.random();
        ItemRarity winItemRarity = null;
        for (ExternalChance chance : chances) {
            startChance += chance.getChanceValue();
            if (rand <= startChance) {
                winItemRarity = chance.getItemRarity();
                break;
            }
        }
        if (winItemRarity == null) {
            LOG.error("Something wrong with Chances");
            return "Something wrong with Chances";
        }
        Item winItem = getFreeItemByRarity(winItemRarity);
        if (winItem == null) {
            LOG.error("Not found clear item rarity: " + winItemRarity.toString());
            return "Not found clear item";
        }
        balance.setValue(balance.getValue() - bet.getBetValue());
        balanceService.updateBalance(balance);

        game.setUser(user);
        game.setBet(bet.getBetValue());
        game.setResult(winItem.getName());
        game.setNumber(-1);
        gameService.insertGame(game);
        game.setNumber(game.getId());
        gameService.updateGame(game);

        winItem.setGame(game);
        winItem.setUser(user);
        itemService.updateItem(winItem);
        return null;
    }


}
