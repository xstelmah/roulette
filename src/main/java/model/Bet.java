package model;

import java.util.List;

public class Bet {

    private Integer id;

    private Float value;

    private ItemRarity rarity;

    private GameType gameType;

    private List<Chance> chances;

    public Bet() {

    }

    public Bet(Float value, ItemRarity rarity) {
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

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Chance> getChances() {
        return chances;
    }

    public void setChances(List<Chance> chances) {
        this.chances = chances;
    }

    @Override
    public String toString() {
        return value.toString() + " " + rarity.toString();
    }
}
