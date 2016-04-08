package model;

import java.util.List;

public class User {

    protected Integer id;

    private String steamLogin;

    private String steamId;

    private String chatLogin;

    private String avatar;

    private Balance balance;

    private List<Game> games;

    private List<ChatMessage> chatMessages;

    private List<Item> items;

    private List<Ticket> tickets;

    private List<TicketMessage> ticketMessages;



    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSteamLogin() {
        return steamLogin;
    }

    public void setSteamLogin(String steamLogin) {
        this.steamLogin = steamLogin;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public String getChatLogin() {
        return chatLogin;
    }

    public void setChatLogin(String chatLogin) {
        this.chatLogin = chatLogin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<TicketMessage> getTicketMessages() {
        return ticketMessages;
    }

    public void setTicketMessages(List<TicketMessage> ticketMessages) {
        this.ticketMessages = ticketMessages;
    }
}
