package model;

import java.util.List;

public class Balance {

    private Integer id;

    private User user;

    private Double value;

    private List<BalanceTransaction> balanceTransactions;

    public Balance() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<BalanceTransaction> getBalanceTransactions() {
        return balanceTransactions;
    }

    public void setBalanceTransactions(List<BalanceTransaction> balanceTransactions) {
        this.balanceTransactions = balanceTransactions;
    }
}
