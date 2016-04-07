package beans;

import model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dao.GameService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class GamesBean {

    private static final Logger LOG = LoggerFactory.getLogger(GamesBean.class);

    private static Integer countGames = 5;

    @ManagedProperty(value = "#{gameService}")
    private GameService gameService;

    public List<Game> lastGames() {
        List<Game> games = gameService.getLastGames(countGames);
        return games;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
