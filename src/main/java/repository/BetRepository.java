package repository;

import model.Bet;
import model.GameType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BetRepository {

    @Results(value = {
            @Result(property = "id", column = "betId", id = true),
            @Result(property = "value", column = "betValue"),
            @Result(property = "rarity", column = "betRarity"),
            @Result(property = "gameType", column = "betGameType"),
            @Result(property = "chances", column ="betId", javaType = List.class,
                    many = @Many(select = "repository.ChanceRepository.getChancesByBetId",fetchType = FetchType.LAZY))
    })
    @Select(value = "select * from Bet where betGameType = #{type}")
    List<Bet> getBetsByGameType(@Param(value = "type")GameType gameType);

    @Results(value = {
            @Result(property = "id", column = "betId", id = true),
            @Result(property = "value", column = "betValue"),
            @Result(property = "rarity", column = "betRarity"),
            @Result(property = "gameType", column = "betGameType"),
            @Result(property = "chances", column ="betId", javaType = List.class,
                    many = @Many(select = "repository.ChanceRepository.getChancesByBetId",fetchType = FetchType.LAZY))
    })
    @Select(value = "select * from Bet where betID = #{id}")
    Bet getBetById(@Param( value = "id") Integer id);
}
