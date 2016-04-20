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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "balanceBean")
@ViewScoped
public class BalanceBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);

    @ManagedProperty(value = "#{balanceService}")
    private BalanceService balanceService;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private Integer value;

    private Integer paymentSystemSelected = 0;

    private List<String> paymentSystems;

    public BalanceBean() {
        LOG.info("BalanceBean created");
        paymentSystems = new ArrayList<>();
        paymentSystems.add("WebMoney");
        paymentSystems.add("PayPal");
        paymentSystems.add("G2A");
        paymentSystems.add("QIWI");
        paymentSystems.add("Alfa-Click");
        paymentSystems.add("Promsvyazbank");
        paymentSystems.add("Sberbank-Online");
    }

    public String currentPaymentSystem() {
        if (paymentSystemSelected == null || paymentSystemSelected < 0 ||
                paymentSystemSelected >= paymentSystems.size())
            return null;
        return paymentSystems.get(paymentSystemSelected);
    }

    public List<String> paymentSystemsImages() {
        List<String> classImages = new ArrayList<>();
        for (String value : paymentSystems) {
            classImages.add((value + "-img").toLowerCase());
        }
        return classImages;
    }

    public Balance actualBalance() {
        if (userBean == null) {
            LOG.error("user bean is null");
            return null;
        }
        if (userBean.getUser() == null) {
            LOG.error("user is null");
            return null;
        }
        return balanceService.getBalanceByUserId(userBean.getUser().getId());
    }

    public void deposit() {
        LOG.info("updateBalance");
        if (userBean == null) {
            LOG.error("user bean is null");
            return;
        }
        if (userBean.getUser() == null || userBean.getUser().getId() == null) {
            LOG.error("user is null");
            return;
        }

        if (value <= 0) {
            LOG.info("value <= 0");
            sendMessage("Error", "Значение должно быть положительным");
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
        sendMessage("Success", "Баланс пополнен на " + value );
    }

    public void sendMessage(String header, String body) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(header, body));
    }

    public Integer getPaymentSystemSelected() {
        return paymentSystemSelected;
    }

    public void setPaymentSystemSelected(Integer paymentSystemSelected) {
        this.paymentSystemSelected = paymentSystemSelected;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

}
