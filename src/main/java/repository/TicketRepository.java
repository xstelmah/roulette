package repository;

import model.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TicketRepository {

    @Results(value = {
            @Result(id = true, property = "id", column = "ticketId"),
            @Result(property = "number", column = "ticketNumber"),
            @Result(property = "dateCreation", column = "ticketDateCreation"),
            @Result(property = "status", column = "ticketStatus"),
            @Result(property = "category", column = "ticketCategory"),
            @Result(property = "additionalInfo", column = "ticketAdditionalInfo"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "ticketMessages", column ="ticketId", javaType = List.class,
            many = @Many(select = "repository.TicketMessageRepository.getTicketMessagesByTicket",fetchType = FetchType.LAZY))
    })
    @Select("SELECT * FROM Ticket where ticketId = #{id}")
    Ticket getTicketById(@Param(value = "id")Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "ticketId"),
            @Result(property = "number", column = "ticketNumber"),
            @Result(property = "dateCreation", column = "ticketDateCreation"),
            @Result(property = "status", column = "ticketStatus"),
            @Result(property = "category", column = "ticketCategory"),
            @Result(property = "additionalInfo", column = "ticketAdditionalInfo"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "ticketMessages", column ="ticketId", javaType = List.class,
                    many = @Many(select = "repository.TicketMessageRepository.getTicketMessagesByTicket",fetchType = FetchType.LAZY))
    })
    @Select("SELECT * FROM Ticket where userId = #{user.id}")
    List<Ticket> getTicketsByUser(@Param(value = "user")User user);


    @Insert("INSERT INTO Ticket " +
            "(userId, adminId , ticketNumber, ticketDateCreation, ticketStatus, ticketCategory, ticketAdditionalInfo)" +
            " VALUES (#{ticket.user.id},#{ticket.admin.id},#{ticket.number},#{ticket.dateCreation},#{ticket.status}," +
            " #{ticket.category},#{ticket.additionalInfo})")
    @Options(useGeneratedKeys = true, keyProperty = "ticket.id", keyColumn = "ticketId")
    void insertTicket(@Param(value = "ticket") Ticket ticket);

    @Update("UPDATE Ticket SET " +
            " userId = #{ticket.user.id} , adminId = #{ticket.admin.id}," +
            " ticketNumber = #{ticket.number}, ticketDateCreation = #{ticket.dateCreation}," +
            " ticketStatus = #{ticket.status}, ticketCategory = #{ticket.category}," +
            " ticketAdditionalInfo = #{ticket.additionalInfo} where ticketId = #{ticket.id}")
    void updateTicket(@Param(value = "ticket") Ticket ticket);
}
