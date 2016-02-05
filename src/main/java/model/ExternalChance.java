package model;

public class ExternalChance {

    private Double chanceValue;

    private ItemRarity itemRarity;

    public ExternalChance(Double chanceValue, ItemRarity itemRarity) {
        this.chanceValue = chanceValue;
        this.itemRarity = itemRarity;
    }

    public Double getChanceValue() {
        return chanceValue;
    }

    public void setChanceValue(Double chanceValue) {
        this.chanceValue = chanceValue;
    }

    public ItemRarity getItemRarity() {
        return itemRarity;
    }

    public void setItemRarity(ItemRarity itemRarity) {
        this.itemRarity = itemRarity;
    }

    @Override
    public String toString() {
        return chanceValue.toString() + " " + itemRarity.toString();
    }

}
