package repository;

import model.Balance;
import model.BalanceTransaction;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TransactionRepository {

    @Results(value = {
            @Result(id = true, property = "id", column = "transactionId"),
            @Result(property = "newBalance", column = "transactionNewBalance"),
            @Result(property = "type", column = "transactionType"),
            @Result(property = "value", column = "transactionValue"),
            @Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY))
    })
    @Select("select * from BalanceTransaction where TransactionId = #{id}")
    BalanceTransaction getTransactionById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "transactionId"),
            @Result(property = "newBalance", column = "transactionNewBalance"),
            @Result(property = "type", column = "transactionType"),
            @Result(property = "value", column = "transactionValue"),
            @Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY))
    })
    @Select("select * from BalanceTransaction where balanceId = #{id}")
    List<BalanceTransaction> getTranscationsByBalanceId(@Param(value = "id")Integer id);
}
