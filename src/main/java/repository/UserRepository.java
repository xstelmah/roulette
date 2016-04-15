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
            @Result(property = "steamTradeUrl", column = "userSteamTradeUrl"),
            @Result(property = "chatLogin", column = "userChatLogin"),
            @Result(property = "avatar", column = "userAvatar"),
            @Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY)),
            @Result(property = "games", javaType = List.class, column = "userId",
                    many = @Many(select = "repository.GameRepository.getGamesByUserId", fetchType = FetchType.LAZY))
    })
    @Select("select * from User where userId = #{id}")
    User getUserById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(property = "id", column = "userId", id = true),
            @Result(property = "steamLogin", column = "userSteamLogin"),
            @Result(property = "steamId", column = "userSteamId"),
            @Result(property = "steamTradeUrl", column = "userSteamTradeUrl"),
            @Result(property = "chatLogin", column = "userChatLogin"),
            @Result(property = "avatar", column = "userAvatar"),
            @Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY)),
            @Result(property = "games", javaType = List.class, column = "userId",
                    many = @Many(select = "repository.GameRepository.getGamesByUserId", fetchType = FetchType.LAZY))
    })
    @Select("select * from User where userSteamId = #{id}")
    User getUserBySteamId(@Param(value = "id") String id);

    @Insert("insert into User (userSteamLogin,userSteamId,userChatLogin) values (#{user.steamLogin},#{user.steamId},#{user.chatLogin})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "userId")
    void insertUser(@Param(value = "user") User user);

    @Update("update User set balanceId = #{user.balance.id}, userSteamLogin = #{user.steamLogin}, "
            + "userChatLogin = #{user.chatLogin}, userSteamId = #{user.steamId}, userSteamTradeUrl  = #{user.steamTradeUrl}" +
            ", userAvatar = #{user.avatar} where userId = #{user.id}")
    void updateUser(@Param(value = "user") User user);
}
