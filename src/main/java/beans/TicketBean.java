package beans;

import model.Ticket;
import model.TicketCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.logic.TicketLogicService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class TicketBean implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(AccessBean.class);

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    @ManagedProperty(value = "#{ticketLogicService}")
    private TicketLogicService ticketLogicService;

    private TicketCategory category;

    private String message;

    public void createNewTicket() {
        if (userBean == null || userBean.getUser() == null || userBean.getUser().getId() == null) return;
        ticketLogicService.createTicket(userBean.getUser(), message, category);
    }


    public TicketCategory getCategory() {
        return category;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public void setTicketLogicService(TicketLogicService ticketLogicService) {
        this.ticketLogicService = ticketLogicService;
    }
}
