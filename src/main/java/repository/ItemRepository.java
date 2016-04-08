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
            @Result(property = "image", column = "itemImage"),
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
            @Result(property = "image", column = "itemImage"),
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
            @Result(property = "image", column = "itemImage"),
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
            @Result(property = "image", column = "itemImage"),
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
            @Result(property = "image", column = "itemImage"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "bot", column = "botId", javaType = Bot.class,
                    one = @One(select = "repository.BotRepository.getBotById", fetchType = FetchType.LAZY)),
            @Result(property = "game", column = "gameId", javaType = Game.class,
                    one = @One(select = "repository.GameRepository.getGameById", fetchType = FetchType.LAZY))
    })
    @Select("(SELECT * FROM Item WHERE userId is NULL AND gameId is NULL AND itemRarity = \"COMMON\" LIMIT #{count})" +
            " UNION " +
            " (SELECT * FROM Item WHERE userId is NULL AND gameId is NULL AND itemRarity = \"UNCOMMON\" LIMIT #{count}) " +
            " UNION " +
            " (SELECT * FROM Item WHERE userId is NULL AND gameId is NULL AND itemRarity = \"RARE\" LIMIT #{count})" +
            " UNION " +
            " (SELECT * FROM Item WHERE userId is NULL AND gameId is NULL AND itemRarity = \"MYTHICAL\" LIMIT #{count})" +
            " UNION " +
            " (SELECT * FROM Item WHERE userId is NULL AND gameId is NULL AND itemRarity = \"LEGENDARY\" LIMIT #{count})" +
            " UNION " +
            " (SELECT * FROM Item WHERE userId is NULL AND gameId is NULL AND itemRarity = \"IMMORTAL\" LIMIT #{count})" +
            " UNION " +
            " (SELECT * FROM Item WHERE userId is NULL AND gameId is NULL AND itemRarity = \"ARCANA\" LIMIT #{count})")
    List<Item> getFreeItems(@Param(value = "count")Integer count);

    @Results(value = {
            @Result(id = true, property = "id", column = "itemId"),
            @Result(property = "name", column = "itemName"),
            @Result(property = "rarity", column = "itemRarity", javaType = ItemRarity.class),
            @Result(property = "type", column = "itemType"),
            @Result(property = "image", column = "itemImage"),
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

    @Insert("Insert INTO Item(itemName,itemRarity,itemType,botId,itemImage)" +
            "values(#{name},#{rarity},#{type},#{bot.id},#{image})"
    )
    void insertItem(Item item);


}
