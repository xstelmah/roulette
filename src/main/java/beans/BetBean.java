package beans;

import model.Bet;
import model.GameType;
import service.dao.BetService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "betBean")
@SessionScoped
public class BetBean implements Serializable {

    @ManagedProperty(value = "#{betService}")
    private BetService betService;


    private List<Bet> bets;

    public BetBean() {
        bets  = betService.getBetsByGameType(GameType.NORMAL);
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBetService(BetService betService) {
        this.betService = betService;
    }
}
