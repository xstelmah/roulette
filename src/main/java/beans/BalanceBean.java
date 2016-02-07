package beans;

import model.Balance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.BalanceService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "balanceBean")
@SessionScoped
public class BalanceBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);

    @ManagedProperty(value = "#{balanceService}")
    private BalanceService balanceService;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private Double value;

    public BalanceBean() {
        LOG.info("BalanceBean created");
        this.value = 0.0;
    }

    public void updateBalance() {
        LOG.info("updateBalance");
        if (userBean == null) {
            LOG.info("user bean is null");
            return;
        }
        if (userBean.getUser() == null) {
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

        Balance balance = balanceService.getBalanceByUserId(userBean.getUser().getId());
        balance.setValue(balance.getValue() + value);
        balanceService.updateBalance(balance);
        LOG.info("Balance update Success");
        sendMessage("Success", "Replenish balance on " + value);
    }

    public void sendMessage(String header, String body) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(header, body));
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public BalanceService getBalanceService() {
        return balanceService;
    }

    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
