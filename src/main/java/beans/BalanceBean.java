package beans;

import model.Balance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.BalanceService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@Component(value = "balanceBean")
@SessionScoped
public class BalanceBean {

    private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);

    @Autowired
    private BalanceService balanceService;

    private Double value;

    public BalanceBean() {
        LOG.info("BalanceBean created");
        this.value = 0.0;
    }

    public void updateBalance(Integer userId) {
        LOG.info("updateBalance");
        if (userId == null) {
            sendMessage("Error", "Not selected user");
            LOG.info("user is null");
            return;
        }
        if (value <= 0) {
            LOG.info("value <= 0");
            sendMessage("Error", "Not correct value");
            return;
        }
        if (balanceService == null) {
            sendMessage("Error", "Service is unavailable");
            LOG.info("balance repository is null");
            return;
        }

        Balance balance = balanceService.getBalanceByUserId(userId);
        balance.setValue(balance.getValue()+value);
        balanceService.updateBalance(balance);
        LOG.info("Balance update Success");
        sendMessage("Success", "Current balance: " + balance.getValue());
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void sendMessage(String header, String body) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(header, body));
    }

}
