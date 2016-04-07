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
            @Result(property = "time", column = "gameTime"),
            @Result(property = "bet", column = "gameBet"),
            @Result(property = "description", column = "gameDescription"),
            @Result(property = "user", column = "userId",
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "item", column = "itemId",
                    one = @One(select = "repository.ItemRepository.getItemById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Game where GameId = #{id}")
    Game getGameById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "gameId"),
            @Result(property = "number", column = "gameNumber"),
            @Result(property = "time", column = "gameTime"),
            @Result(property = "bet", column = "gameBet"),
            @Result(property = "description", column = "gameDescription"),
            @Result(property = "user", column = "userId",
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "item", column = "itemId",
                    one = @One(select = "repository.ItemRepository.getItemById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Game where UserId = #{id}")
    List<Game> getGamesByUserId(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "gameId"),
            @Result(property = "number", column = "gameNumber"),
            @Result(property = "time", column = "gameTime"),
            @Result(property = "bet", column = "gameBet"),
            @Result(property = "description", column = "gameDescription"),
            @Result(property = "user", column = "userId",
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "item", column = "itemId",
                    one = @One(select = "repository.ItemRepository.getItemById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Game limit #{count}")
    List<Game> getLastGames(@Param(value = "count")Integer count);

    @Insert("INSERT into Game(gameBet,gameNumber,gameDescription,gameTime,userId, itemId)" +
            " VALUES(#{bet},#{number},#{description},#{time},#{user.id},#{item.id})")
//    @SelectKey(statement="call identity()", keyProperty="id", keyColumn = "gameId", before=false, resultType=Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "gameId")
    void insertGame(Game game);

    @Update("UPDATE Game SET userId = #{user.id}, itemId = #{item.id}, gameNumber = #{number}, gameTime = #{time}, " +
            " gameDescription = #{description}, gameBet = #{bet} where gameId = #{id}")
    void updateGame(Game game);

}
