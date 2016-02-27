package beans;

import beans.converter.ExternalBetConverter;
import model.Bet;
import model.*;
import org.primefaces.component.dialog.Dialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.logic.GameLogicService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "gameBean")
@ViewScoped
public class GameBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(GameBean.class);

    @ManagedProperty(value = "#{gameLogicService}")
    private GameLogicService gameLogicService;

    private Dialog dialog;

    private List<ItemRarity> baseWinItems;

    private List<Item> renderItems;

    private List<Bet> bets;

    private Bet selectedBet;


    public GameBean() {
        LOG.info("GameBean created");
    }

    @PostConstruct
    void init() {
        LOG.info("Post constructor");
        bets = gameLogicService.getBets(GameType.NORMAL);
        if (bets != null)
            selectedBet = bets.get(0);
        else {
            LOG.error("NOT FOUND BETS");
            return;
        }
        baseWinItems = generateRarityList();
    }

    private List<ItemRarity> generateRarityList() {
        List<ItemRarity> rarityList = new ArrayList<>();
        if (selectedBet != null)
            for (Chance chance : selectedBet.getChances()) {
                rarityList.add(chance.getRarity());
            }
        return rarityList;
    }

    public void playGame(User user) {
        if (user == null) {
            LOG.error("Play game, user is null");
            return;
        }
        if (selectedBet == null) {
            LOG.error("Play game, bet is null");
            return;
        }
        List<Item> itemsResult = gameLogicService.play(user, selectedBet);
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
        selectedBet = null;
        if (event == null) {
            LOG.error("ValueChangeEvent is null in method onSelectBet");
            baseWinItems = generateRarityList();
            return;
        }
        if (event.getNewValue() == null) {
            LOG.warn("New value is null in method onSelectBet");
            baseWinItems = generateRarityList();
            return;
        }
        for (Bet bet : bets) {
            if (bet.getId() != null && bet.getId() == Integer.parseInt((String) event.getNewValue())) {
                selectedBet = bet;
            }
        }
        if (selectedBet == null) {
            LOG.error("Can't convert value to externalBet");
            baseWinItems = generateRarityList();
            return;
        }
        baseWinItems = generateRarityList();

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

    public List<Bet> getBets() {
        return bets;
    }

    public void setGameLogicService(GameLogicService gameLogicService) {
        this.gameLogicService = gameLogicService;
    }
}