package beans;

import model.BalanceTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "transactionBean")
@SessionScoped
public class TransactionBean implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(TransactionBean.class);

    private BalanceTransaction balanceTransaction;

    public TransactionBean() {
        LOG.info("TransactionBean created");
        this.balanceTransaction = new BalanceTransaction();
    }

    public BalanceTransaction getBalanceTransaction() {
        return balanceTransaction;
    }

    public void setBalanceTransaction(BalanceTransaction balanceTransaction) {
        this.balanceTransaction = balanceTransaction;
    }
}
