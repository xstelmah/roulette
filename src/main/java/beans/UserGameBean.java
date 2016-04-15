package beans;

import model.Bet;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dao.BetService;
import service.logic.GameLogicService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserGameBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(UserGameBean.class);

    @ManagedProperty(value = "#{gameLogicService}")
    private GameLogicService gameLogicService;

    @ManagedProperty(value = "#{betService}")
    private BetService betService;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private Boolean renderedRoulette = false;

    private List<Item> renderItems;


    private Integer selectedMenuItem = null;

    private Bet selectedBet = null;


    public UserGameBean() {
        LOG.info("GameBean created");
    }


    public void setSelectedMenuItem(Integer selectedMenuItem) {
        this.selectedMenuItem = selectedMenuItem;
        List<Bet> bets = gameLogicService.getBets(GameType.NORMAL);
        if (selectedMenuItem == null || selectedMenuItem < 0 || selectedMenuItem >= bets.size()) {
            this.selectedMenuItem = null;
            selectedBet = null;
        } else {
            selectedBet = bets.get(selectedMenuItem);
        }
    }

    public List<String> userMenuImages() {
        List<String> classNames = new LinkedList<>();
        List<Bet> bets = gameLogicService.getBets(GameType.NORMAL);
        for (Bet bet : bets) {
            classNames.add("background-" +bet.getRarity().getName().toLowerCase());
        }
        return classNames;
    }

    public List<String> userPotentialItemImages() {
        List<String> imagesPath = new LinkedList<>();
        if (selectedBet == null) return null;
        for (Chance chance : selectedBet.getChances()) {
            imagesPath.add("/resources/images/" + chance.getRarity().getName() + ".jpg");
        }
        return imagesPath;
    }

    public void userPlay() {
        if (userBean == null || userBean.getUser() == null || userBean.getUser().getId() == null) {
            sendMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Вы не авторизированы");
            LOG.error("NOT SELECTED BET");
            return;
        }
        if (selectedBet == null) {
            sendMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Не выбрана ставка");
            LOG.error("NOT SELECTED BET");
            return;
        }
        Bet bet = betService.getBetById(selectedBet.getId());
        if (selectedBet == null) {
            sendMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Сервер временно недоступен");
            LOG.error("No response from db");
            return;
        }

        List<Item> itemsResult = gameLogicService.playOnMoney(userBean.getUser(), selectedBet);
        if (itemsResult != null) {
            renderedRoulette = true;
            renderItems = itemsResult;
        } else {
            renderedRoulette = false;
            sendMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Недостаточно средств");
        }

    }

    public void sendMessage(FacesMessage.Severity severity, String header, String body) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, header, body));
    }

    public List<Item> getRenderItems() {
        return renderItems;
    }

    public void setRenderItems(List<Item> renderItems) {
        this.renderItems = renderItems;
    }

    public Boolean getRenderedRoulette() {
        return renderedRoulette;
    }

    public void setRenderedRoulette(Boolean renderedRoulette) {
        this.renderedRoulette = renderedRoulette;
    }

    public Integer getSelectedMenuItem() {
        return selectedMenuItem;
    }

    public Bet getSelectedBet() {
        return selectedBet;
    }

    public void setSelectedBet(Bet selectedBet) {
        this.selectedBet = selectedBet;
    }


    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public void setBetService(BetService betService) {
        this.betService = betService;
    }

    public void setGameLogicService(GameLogicService gameLogicService) {
        this.gameLogicService = gameLogicService;
    }

}