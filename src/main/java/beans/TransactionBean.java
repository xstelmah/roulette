package beans;

import model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "transactionBean")
@SessionScoped
public class TransactionBean implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(TransactionBean.class);

    private Transaction transaction;

    public TransactionBean() {
        LOG.info("TransactionBean created");
        this.transaction = new Transaction();
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
