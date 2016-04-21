package service.dao;

import model.Ticket;
import model.TicketMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TicketMessageRepository;

import java.util.List;

@Service
public class TicketMessageService {

    @Autowired
    private TicketMessageRepository repository;

    public TicketMessage getTicketMessageById(Integer id) {
        return repository.getTicketMessageById(id);
    }

    public List<TicketMessage> getTicketMessagesByTicket(Ticket ticket) {
        return repository.getTicketMessagesByTicket(ticket);
    }

    public void insertTicket(TicketMessage message) {
        repository.insertTicket(message);
    }

    public void updateTicketMessage(TicketMessage message) {
        repository.updateTicketMessage(message);
    }
}
