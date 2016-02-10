package repository;

import model.Balance;
import model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserRepository {

    @Results(value = {
            @Result(property = "id", column = "userId", id = true),
            @Result(property = "login", column = "userLogin"),
            @Result(property = "password", column = "userPassword"),
            @Result(property = "mail", column = "userMail"),
            @Result(property = "alternativeLogin",column = "userAlternativeLogin"),
            @Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY)),
            @Result(property = "games", javaType = List.class, column = "userId",
                    many = @Many(select = "repository.GameRepository.getGamesByUserId", fetchType = FetchType.LAZY))
    })
    @Select("select * from User where UserId = #{id}")
    User getUserById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(property = "id", column = "userId", id = true),
            @Result(property = "login", column = "userLogin"),
            @Result(property = "password", column = "userPassword"),
            @Result(property = "mail", column = "userMail"),
            @Result(property = "alternativeLogin",column = "userAlternativeLogin"),
            @Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY)),
            @Result(property = "games", javaType = List.class, column = "userId",
                    many = @Many(select = "repository.GameRepository.getGamesByUserId", fetchType = FetchType.LAZY))
    })
    @Select("select * from User")
    List<User> getUsers();

    @Results(value = {
            @Result(property = "id", column = "userId", id = true),
            @Result(property = "login", column = "userLogin"),
            @Result(property = "password", column = "userPassword"),
            @Result(property = "mail", column = "userMail"),
            @Result(property = "alternativeLogin",column = "userAlternativeLogin"),
            @Result(property = "balance", column = "balanceId", javaType = Balance.class,
                    one = @One(select = "repository.BalanceRepository.getBalanceById", fetchType = FetchType.LAZY)),
            @Result(property = "games", javaType = List.class, column = "userId",
                    many = @Many(select = "repository.GameRepository.getGamesByUserId", fetchType = FetchType.LAZY))
    })
    @Select("select * from User where UserLogin = #{login} and UserPassword = #{password}")
    User getUserByLoginPassword(@Param(value = "login") String login,
                                @Param(value = "password") String password);

}
