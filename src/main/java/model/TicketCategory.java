package model;

public enum TicketCategory {
    NONE("Не выбрана"),
    BALANCE("Проблемы с балансом"),
    OTHER("Другое");

    private final String message;

    TicketCategory(String  message) {
        this.message = message;
    }

}
