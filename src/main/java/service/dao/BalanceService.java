package service.dao;

import model.Balance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BalanceRepository;

@Service(value = "balanceService")
public class BalanceService{

    private static final Logger LOG = LoggerFactory.getLogger(BalanceService.class);

    @Autowired
    private BalanceRepository balanceRepository;

    public Balance getBalanceById(Integer id) {
        return balanceRepository.getBalanceById(id);
    }

    public Balance getBalanceByUserId(Integer id) {
        return balanceRepository.getBalanceByUserId(id);
    }

    public void updateBalance(Balance balance) {
        balanceRepository.updateBalance(balance);
    }

}
