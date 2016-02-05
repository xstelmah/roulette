package repository;

import model.Bot;
import model.Item;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BotRepository {

    @Results(value = {
            @Result(property = "id", column = "botId", id = true),
            @Result(property = "name", column = "botName"),
            @Result(property = "items", column ="botId", javaType = List.class,
            many = @Many(select = "repository.ItemRepository.getItemsByBotId",fetchType = FetchType.LAZY))
    })
    @Select("select * from Bot where botId = #{id}")
    Bot getBotById(@Param(value = "id") Integer id);
}
