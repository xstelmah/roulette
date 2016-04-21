package repository;

import model.Ticket;
import model.TicketMessage;
import model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TicketMessageRepository {

    @Results(value = {
            @Result(id = true, property = "id", column = "ticketMessageId"),
            @Result(property = "date", column = "ticketMessageDate"),
            @Result(property = "message", column = "ticketMessageMessage"),
            @Result(property = "status", column = "ticketStatus"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "ticket", column = "ticketId", javaType = Ticket.class,
            one = @One(select = "repository.TicketRepository.getTicketById", fetchType = FetchType.LAZY))
    })
    @Select("SELECT * FROM TicketMessage where ticketMessageId = #{id}")
    TicketMessage getTicketMessageById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(id = true, property = "id", column = "ticketMessageId"),
            @Result(property = "date", column = "ticketMessageDate"),
            @Result(property = "message", column = "ticketMessageMessage"),
            @Result(property = "status", column = "ticketStatus"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "repository.UserRepository.getUserById", fetchType = FetchType.LAZY)),
            @Result(property = "ticket", column = "ticketId", javaType = Ticket.class,
                    one = @One(select = "repository.TicketRepository.getTicketById", fetchType = FetchType.LAZY))
    })
    @Select("SELECT * FROM TicketMessage where ticketId = #{ticket.id}")
    List<TicketMessage> getTicketMessagesByTicket(@Param(value = "ticket") Ticket ticket);


    @Insert("INSERT INTO TicketMessage " +
            "(ticketId, userId , adminId, ticketMessageDate, ticketMessageMessage)" +
            " VALUES (#{message.ticket.id},#{message.user.id},#{message.admin.id},#{message.date},#{message.message})")
    void insertTicket(@Param(value = "message") TicketMessage message);

    @Update("UPDATE TicketMessage SET " +
            " ticketId = #{message.ticket.id} , adminId = #{message.admin.id}," +
            " userId = #{message.user.id}, ticketMessageDate = #{message.date}," +
            " ticketMessageMessage = #{message.message} where ticketMessageId = #{message.id}")
    void updateTicketMessage(@Param(value = "message") TicketMessage message);

}
