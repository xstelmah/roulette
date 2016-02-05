package beans;

import model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TransactionBean {
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
