package model;

import java.util.List;

public class User {

    protected Integer id;

    private String login;

    private String password;

    private String mail;

    private Balance balance;

    private String alternativeLogin;

    private List<Game> games;

    private List<Message> messages;

    private List<Item> items;

    public User() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getAlternativeLogin() {
        return alternativeLogin;
    }

    public void setAlternativeLogin(String alternativeLogin) {
        this.alternativeLogin = alternativeLogin;
    }
}
