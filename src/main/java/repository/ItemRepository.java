package repository;

import model.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ItemRepository {

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity", javaType = ItemRarity.class),
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
            @Result(property = "rarity", column = "itemRarity", javaType = ItemRarity.class),
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
            @Result(property = "rarity", column = "itemRarity", javaType = ItemRarity.class),
            @Result(property = "type", column = "itemType"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Item where gameId = #{id}")
    Item getItemByGameId(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity", javaType = ItemRarity.class),
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
            @Result(property = "rarity", column = "itemRarity", javaType = ItemRarity.class),
            @Result(property = "type", column = "itemType"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("select * from Item where gameId is null AND userId is null AND itemRarity = #{rarity} Limit 0,1")
    Item getFreeItemByRarity(@Param(value = "rarity") ItemRarity rarity);

    @Update("UPDATE Item SET " +
            " botId =#{bot.id},gameId = #{game.id}, userId = #{user.id}, " +
            " itemName = #{name},itemRarity = #{rarity}, itemType = #{type}" +
            " WHERE itemId = #{id}")
    void updateItem(Item item);

    @Insert("Insert INTO Item(itemName,itemRarity,itemType,botId)" +
            "values(#{name},#{rarity},#{type},#{botId})"
    )
    void insertItem(Item item);


}
