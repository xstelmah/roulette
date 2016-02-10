package model;

public class Bet {

    private Float value;

    private ItemRarity rarity;

    public Bet(Float value, ItemRarity rarity) {
        this.value = value;
        this.rarity = rarity;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Double Float) {
        this.value = value;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return value.toString() + " " + rarity.toString();
    }
}
