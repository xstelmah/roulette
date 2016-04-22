package model;

public enum TicketStatus {
    NONE("Отсутствует"),
    USER_POSTED("Отправлен Пользователем"),
    ADMIN_POSTED("Отправлен Администратором"),
    CLOSED_BY_USER("Закрыт Пользователем"),
    CLOSED_BY_ADMIN("Закрыт Администратором");

    private final String value;

    TicketStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
