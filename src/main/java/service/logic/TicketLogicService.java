package service.logic;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.dao.TicketMessageService;
import service.dao.TicketService;

import java.util.Date;

@Service
public class TicketLogicService {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketMessageService ticketMessageService;

    public String createTicket(User user, String message, TicketCategory category) {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setAdmin(new Admin());
        ticket.setCategory(category);
        ticket.setDateCreation(new Date(System.currentTimeMillis()));
        ticket.setStatus(TicketStatus.USER_POSTED);
        ticketService.insertTicket(ticket);
        ticket.setNumber(ticket.getId());
        ticketService.updateTicket(ticket);

        TicketMessage ticketMessage = new TicketMessage();
        ticketMessage.setAdmin(new Admin());
        ticketMessage.setUser(user);
        ticketMessage.setDate(new Date(System.currentTimeMillis()));
        ticketMessage.setTicket(ticket);
        ticketMessage.setMessage(message);
        ticketMessageService.insertTicket(ticketMessage);

        return null;
    }
}
