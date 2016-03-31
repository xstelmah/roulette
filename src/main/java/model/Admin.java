package model;

import java.util.List;

public class Admin {

    private Integer id;

    private String login;

    private String password;

    private List<Ticket> tickets;

    private List<TicketMessage> ticketMessages;

    private List<Item> items;

    public Admin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<TicketMessage> getTicketMessages() {
        return ticketMessages;
    }

    public void setTicketMessages(List<TicketMessage> ticketMessages) {
        this.ticketMessages = ticketMessages;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
