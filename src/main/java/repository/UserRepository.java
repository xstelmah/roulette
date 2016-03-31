package repository;

import model.Balance;
import model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserRepository {

    @Results(value = {
            @Result(property = "id", column = "userId", id = true),
            @Result(property = "steamLogin", column = "userSteamLogin"),
            @Result(property = "steamId", column = "userSteamId"),
            @Result(property = "chatLogin", column = "userChatLogin")
            /*@Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY)),
            @Result(property = "games", javaType = List.class, column = "userId",
                    many = @Many(select = "repository.GameRepository.getGamesByUserId", fetchType = FetchType.LAZY))*/
    })
    @Select("select * from User where userId = #{id}")
    User getUserById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(property = "id", column = "userId", id = true),
            @Result(property = "steamLogin", column = "userSteamLogin"),
            @Result(property = "steamId", column = "userSteamId"),
            @Result(property = "chatLogin", column = "userChatLogin")
            /*@Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY)),
            @Result(property = "games", javaType = List.class, column = "userId",
                    many = @Many(select = "repository.GameRepository.getGamesByUserId", fetchType = FetchType.LAZY))*/
    })
    @Select("select * from User where userSteamId = #{id}")
    User getUserBySteamId(@Param(value = "id")String  id);
}
