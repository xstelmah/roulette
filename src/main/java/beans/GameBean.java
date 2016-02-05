package beans;

import beans.converter.ExternalBetConverter;
import model.ExternalBet;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.BalanceService;
import service.dao.GameService;
import service.dao.ItemService;
import service.dao.UserService;
import service.logic.GameLogicService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component(value = "gameBean")
@SessionScoped
public class GameBean {

    private static final Logger LOG = LoggerFactory.getLogger(GameBean.class);

    public static final Integer ITEM_LOAD_COUNT = 33;

    @Autowired
    private ExternalBetConverter externalBetConverter;

    @Autowired
    private GameLogicService gameLogicService;


    private Boolean renderRoullete;

    private List<ItemRarity> baseWinItems;

    private List<ExternalBet> bets;

    private ExternalBet selectedExternalBet;


    public GameBean() {
        LOG.info("GameBean created");
        bets = new ArrayList<>();
        renderRoullete = false;
        bets.add(new ExternalBet(2.0, ItemRarity.COMMON));
        bets.add(new ExternalBet(5.0, ItemRarity.UNCOMMON));
        bets.add(new ExternalBet(10.0, ItemRarity.RARE));
        bets.add(new ExternalBet(20.0, ItemRarity.MYTHICAL));
        baseWinItems = generateRarityList(ItemRarity.COMMON);
    }


    private List<ItemRarity> generateRarityList(ItemRarity rarityStart) {
        List<ItemRarity> rarityList = new ArrayList<>();
        for (ItemRarity item : ItemRarity.values()) {
            if (item.getValue() >= rarityStart.getValue()) {
                rarityList.add(item);
            }
        }
        return rarityList;
    }

    public List<ItemRarity> takeImg() {
        Integer minIndex = (selectedExternalBet == null) ? 0 : selectedExternalBet.getItemRarity().getValue();
        List<ItemRarity> itemList = new ArrayList<>();
        for (int i = 0; i < ITEM_LOAD_COUNT; i++) {
            Random random = new Random();
            int rInt = random.nextInt(7 - minIndex) + minIndex;
            for (ItemRarity item : ItemRarity.values()) {
                if (item.getValue() == rInt) {
                    itemList.add(item);
                }
            }
        }
        return itemList;
    }

    public void playGame(User user) {
        renderRoullete = false;
        if (user == null) {
            LOG.error("Play game, user is null");
            return;
        }
        if (selectedExternalBet == null) {
            LOG.error("Play game, bet is null");
            return;
        }
        String result = gameLogicService.play(user, selectedExternalBet);
        if (result == null)
        {
            renderRoullete = true;
            sendMessage(FacesMessage.SEVERITY_INFO,"SUCCESS", "");
        }
        else
        {
            sendMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "");
        }

    }

    public void onSelectBet(ValueChangeEvent event) {
        LOG.info("Start method onSelectBet");
        if (event == null) {
            LOG.error("ValueChangeEvent is null in method onSelectBet");
            selectedExternalBet = null;
            baseWinItems = generateRarityList(ItemRarity.COMMON);
            return;
        }
        if (event.getNewValue() == null) {
            LOG.warn("New value is null in method onSelectBet");
            selectedExternalBet = null;
            baseWinItems = generateRarityList(ItemRarity.COMMON);
            return;
        }
        selectedExternalBet = (ExternalBet) externalBetConverter.getAsObject(null, null, event.getNewValue().toString());
        if (selectedExternalBet == null) {
            LOG.error("Can't convert value to externalBet");
            baseWinItems = generateRarityList(ItemRarity.COMMON);
            return;
        }
        baseWinItems = generateRarityList(selectedExternalBet.getItemRarity());

    }

    public Boolean getRenderRoullete() {
        return renderRoullete;
    }

    public List<ItemRarity> getBaseWinItems() {
        return baseWinItems;
    }

    public List<ExternalBet> getBets() {
        return bets;
    }

    public void sendMessage(FacesMessage.Severity severity, String header, String body) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, header, body));
    }

}
