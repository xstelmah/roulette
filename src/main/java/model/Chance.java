package model;

public class Chance {

    private Float value;

    private ItemRarity rarity;

    public Chance() {

    }

    public Chance(Float value, ItemRarity rarity) {
        this.value = value;
        this.rarity = rarity;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
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
