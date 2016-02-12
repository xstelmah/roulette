package model;

public enum ItemRarity {
    COMMON(0, "Common"),
    UNCOMMON(1, "Uncommon"),
    RARE(2, "Rare"),
    MYTHICAL(3, "Mythical"),
    IMMORTAL(4, "Immortal"),
    LEGENDARY(5, "Legendary"),
    ARCANA(6, "Arcana");

    private final Integer value;

    private final String name;

    ItemRarity(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
