package model;

public enum GameType {
    NORMAL(0),
    TEST(1);

    private final Integer value;

    GameType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
