package service.dao;

import model.Chance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ChanceRepository;

import java.util.List;

@Service(value = "chanceService")
public class ChanceService {

    private static final Logger LOG = LoggerFactory.getLogger(ChanceService.class);

    @Autowired
    private ChanceRepository chanceRepository;

    public List<Chance> getChancesByBetId(Integer id) {
        return  chanceRepository.getChancesByBetId(id);
    }

}
