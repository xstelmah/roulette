package model;

public class ExternalBet {

    private Double betValue;

    private ItemRarity itemRarity;

    public ExternalBet(Double betValue, ItemRarity itemRarity) {
        this.betValue = betValue;
        this.itemRarity = itemRarity;
    }

    public Double getBetValue() {
        return betValue;
    }

    public void setBetValue(Double betValue) {
        this.betValue = betValue;
    }

    public ItemRarity getItemRarity() {
        return itemRarity;
    }

    public void setItemRarity(ItemRarity itemRarity) {
        this.itemRarity = itemRarity;
    }

    @Override
    public String toString() {
        return betValue.toString() + " " + itemRarity.toString();
    }
}
