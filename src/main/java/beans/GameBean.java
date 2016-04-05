package beans;

import model.Bet;
import model.*;
import org.primefaces.component.dialog.Dialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dao.BetService;
import service.logic.GameLogicService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "gameBean")
@SessionScoped
public class GameBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(GameBean.class);

    @ManagedProperty(value = "#{gameLogicService}")
    private GameLogicService gameLogicService;

    @ManagedProperty(value = "#{betService}")
    private BetService betService;

    private Boolean renderedRoulette = false;

//    private Dialog dialog;

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
        List<Item> itemsResult = gameLogicService.playOnMoney(user, selectedBet);
        if (itemsResult != null) {
//            dialog.setVisible(true);
            renderItems = itemsResult;
        } else {
//            dialog.setVisible(false);
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
//
//    public Dialog getDialog() {
//        return dialog;
//    }
//
//    public void setDialog(Dialog dialog) {
//        this.dialog = dialog;
//    }

    public List<Item> getRenderItems() {
        return renderItems;
    }

    public List<ItemRarity> getBaseWinItems() {
        return baseWinItems;
    }

    public List<Bet> getBets() {
        return bets;
    }


    // new method after total changing
    public List<String> guestImages() {
        List<String> imagesPath = new LinkedList<>();
        List<Bet> bets = gameLogicService.getBets(GameType.TEST);
        for (Bet bet : bets) {
            imagesPath.add("\"/resources/images/" + bet.getRarity().getName() + ".jpg\"");
        }
        return imagesPath;
    }

    public void guestPlay() {
        String menuItem = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("menuItem");
        if (menuItem == null) {
            sendMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Не выбрана ставка");
            LOG.error("NOT SELECTED BET");
            return;
        }

        Bet bet = new Bet();
        switch (menuItem) {
            case "0": {
                bet.setId(6);
                break;
            }
            case "1": {
                bet.setId(7);
                break;
            }
            case "2": {
                bet.setId(8);
                break;
            }
            case "3": {
                bet.setId(9);
                break;
            }
            default: {
                sendMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Не выбрана ставка");
                return;
            }
        }
        bet = betService.getBetById(bet.getId());
        List<Item> itemsResult = gameLogicService.playFree(bet);
        if (itemsResult != null) {
            renderedRoulette = true;
            renderItems = itemsResult;
        } else {
            renderedRoulette = false;
            sendMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Try again");
        }
    }

    public void setGameLogicService(GameLogicService gameLogicService) {
        this.gameLogicService = gameLogicService;
    }

    public void setBetService(BetService betService) {
        this.betService = betService;
    }

    public Boolean getRenderedRoulette() {
        return renderedRoulette;
    }

    public void setRenderedRoulette(Boolean renderedRoulette) {
        this.renderedRoulette = renderedRoulette;
    }
}