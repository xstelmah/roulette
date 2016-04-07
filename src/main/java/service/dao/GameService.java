package service.dao;

import model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GameRepository;

import java.util.List;

@Service(value = "gameService")
public class GameService {

    private static final Logger LOG = LoggerFactory.getLogger(BalanceService.class);

    @Autowired
    private GameRepository gameRepository;

    public Game getGameById(Integer id) {
        return gameRepository.getGameById(id);
    }

    public List<Game> getGamesByUserId(Integer id) {
        return gameRepository.getGamesByUserId(id);
    }

    public List<Game> getLastGames(Integer count) {
        return gameRepository.getLastGames(count);
    }

    public void insertGame(Game game) {
        gameRepository.insertGame(game);
    }

    public void updateGame(Game game) {
        gameRepository.updateGame(game);
    }

}
