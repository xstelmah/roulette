package repository;

import model.Bet;
import model.Chance;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ChanceRepository {

    @Results(value = {
            @Result(property = "id", column = "chanceId", id = true),
            @Result(property = "value", column = "chanceValue"),
            @Result(property = "rarity", column = "chanceRarity"),
            @Result(property = "bet", column ="betId", javaType = Bet.class,
                    one = @One(select = "repository.BetRepository.getBetById",fetchType = FetchType.LAZY))
    })
    @Select("select * from Chance where betId = #{id}")
    List<Chance> getChancesByBetId(@Param(value = "id") Integer id);
}
