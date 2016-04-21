package model;


import java.util.Date;
import java.util.List;

public class Ticket {

    private Integer id;

    private Integer number;

    private Date dateCreation;

    private TicketStatus status;

    private TicketCategory category;

    private String additionalInfo;

    private User user;

    private Admin admin;

    private List<TicketMessage> ticketMessages;

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketCategory getCategory() {
        return category;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<TicketMessage> getTicketMessages() {
        return ticketMessages;
    }

    public void setTicketMessages(List<TicketMessage> ticketMessages) {
        this.ticketMessages = ticketMessages;
    }
}
