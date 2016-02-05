package service.dao;

import model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TransactionRepository;

import java.util.List;

@Service(value = "transactionService")
public class TransactionService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getTransactionById(Integer id) {
        return transactionRepository.getTransactionById(id);
    }

    public List<Transaction> getTranscationsByBalanceId(Integer id) {
      return transactionRepository.getTranscationsByBalanceId(id);
    }

}
