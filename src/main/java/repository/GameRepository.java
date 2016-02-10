package repository;

import model.Game;
import model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface GameRepository {

    @Results(value = {
            @Result(id = true, property = "id", column = "gameId"),
            @Result(property = "number", column = "gameNumber"),
            @Result(property = "startTime", column = "gameStartTime"),
            @Result(property = "bet", column = "gameBet"),
            @Result(property = "description", column = "gameDescription"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Game where GameId = #{id}")
    Game getGameById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "gameId"),
            @Result(property = "number", column = "gameNumber"),
            @Result(property = "startTime", column = "gameStartTime"),
            @Result(property = "bet", column = "gameBet"),
            @Result(property = "description", column = "gameDescription"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "items", column = "gameId", javaType = List.class,
                    many = @Many(select = "repository.ItemRepository.getItemsByGameId", fetchType = FetchType.LAZY))
    })
    @Select("select * from Game where UserId = #{id}")
    List<Game> getGamesByUserId(@Param(value = "id") Integer id);

    @Insert("INSERT into Game(gameBet,gameNumber,gameDescription,gameStartTime,userId)" +
            " VALUES(#{bet},#{number},#{description},#{startTime},#{user.id})")
//    @SelectKey(statement="call identity()", keyProperty="id", keyColumn = "gameId", before=false, resultType=Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "gameId")
    void insertGame(Game game);

    @Update("UPDATE Game SET userId = #{user.id}, gameNumber = #{number}, gameStartTime = #{startTime}, " +
            " gameDescription = #{description}, gameBet = #{bet} where gameId = #{id}")
    void updateGame(Game game);

}
