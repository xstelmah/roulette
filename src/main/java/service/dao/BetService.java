package service.dao;

import model.Bet;
import model.GameType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BetRepository;

import java.util.List;

@Service(value = "betService")
public class BetService {

    private static final Logger LOG = LoggerFactory.getLogger(BetService.class);

    @Autowired
    private BetRepository betRepository;

    public Bet getBetById(Integer id) {
        return betRepository.getBetById(id);
    }

    public List<Bet> getBetsByGameType(GameType gameType) {
        return betRepository.getBetsByGameType(gameType);
    }

}
