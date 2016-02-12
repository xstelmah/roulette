package model;

public class Chance {

    private Integer id;

    private Float value;

    private ItemRarity rarity;

    private Bet bet;

    public Chance() {

    }

    public Chance(Float value, ItemRarity rarity) {
        this.value = value;
        this.rarity = rarity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        return value.toString() + " " + rarity.toString();
    }

}
