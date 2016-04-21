package service.dao;

import model.Ticket;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket getTicketById(Integer id) {
        return ticketRepository.getTicketById(id);
    }

    public List<Ticket> getTicketsByUser(User user) {
        return ticketRepository.getTicketsByUser(user);
    }

    public void insertTicket(Ticket ticket) {
        ticketRepository.insertTicket(ticket);
    }

    public void updateTicket(Ticket ticket) {
        ticketRepository.updateTicket(ticket);
    }

}
