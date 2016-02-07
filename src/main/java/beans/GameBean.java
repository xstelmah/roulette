package beans;

import beans.converter.ExternalBetConverter;
import model.ExternalBet;
import model.*;
import org.primefaces.component.dialog.Dialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.logic.GameLogicService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ManagedBean(name = "gameBean")
@ViewScoped
public class GameBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(GameBean.class);

    @ManagedProperty(value = "#{externalBetConverter}")
    private ExternalBetConverter externalBetConverter;

    @ManagedProperty(value = "#{gameLogicService}")
    private GameLogicService gameLogicService;

    private Dialog dialog;

    private List<ItemRarity> baseWinItems;

    private List<Item> renderItems;

    private List<ExternalBet> bets;

    private ExternalBet selectedExternalBet;


    public GameBean() {
        LOG.info("GameBean created");
        bets = new ArrayList<>();
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

    public void playGame(User user) {
        if (user == null) {
            LOG.error("Play game, user is null");
            return;
        }
        if (selectedExternalBet == null) {
            LOG.error("Play game, bet is null");
            return;
        }
        List<Item> itemsResult = gameLogicService.play(user, selectedExternalBet);
        if (itemsResult != null) {
            dialog.setVisible(true);
            renderItems = itemsResult;
//            sendMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", null);
        } else {
            dialog.setVisible(false);
            sendMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Not enough gold");
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

    public void sendMessage(FacesMessage.Severity severity, String header, String body) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, header, body));
    }



    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public List<Item> getRenderItems() {
        return renderItems;
    }

    public List<ItemRarity> getBaseWinItems() {
        return baseWinItems;
    }

    public List<ExternalBet> getBets() {
        return bets;
    }

    public ExternalBetConverter getExternalBetConverter() {
        return externalBetConverter;
    }

    public GameLogicService getGameLogicService() {
        return gameLogicService;
    }

    public void setExternalBetConverter(ExternalBetConverter externalBetConverter) {
        this.externalBetConverter = externalBetConverter;
    }

    public void setGameLogicService(GameLogicService gameLogicService) {
        this.gameLogicService = gameLogicService;
    }
}