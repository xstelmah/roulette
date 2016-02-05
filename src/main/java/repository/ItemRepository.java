package repository;

import model.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ItemRepository {

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity"),
            @Result(property = "type", column = "itemType"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Item where itemId = #{id}")
    Item getItemById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity"),
            @Result(property = "type", column = "itemType"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Item where userId = #{id}")
    List<Item> getItemsByUserId(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity"),
            @Result(property = "type", column = "itemType"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Item where gameId = #{id}")
    List<Item> getItemsByGameId(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity"),
            @Result(property = "type", column = "itemType"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Item where botId = #{id}")
    List<Item> getItemsByBotId(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity"),
            @Result(property = "type", column = "itemType"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Item where gameId is null AND userId is null AND itemRarity = #{rarity} Limit 0,1")
    Item getFreeItemByRarity(@Param(value = "rarity") String rarity);

    @Update("UPDATE Item SET gameId = #{gameId}, userId = #{userId} WHERE itemId = #{itemId}")
    void updateGameAndUserInItem(@Param(value = "gameId") Integer gameId,
                                 @Param(value = "userId") Integer userId,
                                 @Param(value = "itemId") Integer itemId);

    @Insert("Insert  INTO Item(itemId,itemName,itemRarity,itemType,botId)" +
            "values(#{id},#{name},#{rarity},#{type},#{botId})"
    )
    void insertItem(@Param(value = "id") Integer id, @Param(value = "name") String name,
                    @Param(value = "rarity") String rarity, @Param(value = "type") String type,
                    @Param(value = "botId") Integer botId);


}
