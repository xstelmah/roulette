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
            @Result(property = "result", column = "gameResult"),
            @Result(property = "startTime", column = "gameStartTime"),
            @Result(property = "bet", column = "gameBet"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Game where GameId = #{id}")
    Game getGameById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "gameId"),
            @Result(property = "number", column = "gameNumber"),
            @Result(property = "result", column = "gameResult"),
            @Result(property = "startTime", column = "gameStartTime"),
            @Result(property = "bet", column = "gameBet"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "items", column = "gameId", javaType = List.class,
             many = @Many(select = "repository.ItemRepository.getItemsByGameId", fetchType = FetchType.LAZY))
    })
    @Select("select * from Game where UserId = #{id}")
    List<Game> getGamesByUserId(@Param(value = "id") Integer id);

    @Insert("INSERT into Game(gameBet,gameNumber,gameResult,gameStartTime,userId)"+
            " VALUES(#{bet},#{number},#{result},#{startTime},#{user.id})")
//    @SelectKey(statement="call identity()", keyProperty="id", keyColumn = "gameId", before=false, resultType=Integer.class)
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="gameId")
    void insertGame(Game game);

    @Select("SELECT gameId FROM Game WHERE userId = #{id} \n" +
            "ORDER BY gameId desc \n" +
            "Limit 0,1")
    Integer getLastGameByUserId(@Param(value = "id")Integer id);

}
