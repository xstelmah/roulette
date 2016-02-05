package repository;

import model.Balance;
import model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.*;

public interface BalanceRepository {

    @Results(value = {
            @Result(property = "id", column = "balanceId", id = true),
            @Result(property = "value", column = "balanceValue"),
            @Result(property = "user", column = "userId",javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById",fetchType = FetchType.LAZY)),
            @Result(property = "transactions", column = "balanceId", javaType = List.class,
                    many = @Many(select = "repository.TransactionRepository.getTranscationsByBalanceId",fetchType = FetchType.LAZY))
    })
    @Select("select * from Balance where BalanceId = #{id}")
    Balance getBalanceById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(property = "id", column = "balanceId", id = true),
            @Result(property = "value", column = "balanceValue"),
            @Result(property = "user", column = "userId",javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById",fetchType = FetchType.LAZY)),
            @Result(property = "transactions", column = "balanceId", javaType = List.class,
                    many = @Many(select = "repository.TransactionRepository.getTranscationsByBalanceId",fetchType = FetchType.LAZY))
    })
    @Select("select * from Balance where userId = #{id}")
    Balance getBalanceByUserId(User user);


    @Update("UPDATE Balance SET balanceValue = #{value}, userId = #{user.id} WHERE balanceId =#{id}")
    void updateBalance(Balance balance);
}
