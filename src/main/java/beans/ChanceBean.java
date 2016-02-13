package beans;

import model.Chance;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "chanceBean")
@SessionScoped
public class ChanceBean {


    private Chance chance;

    public Chance getChance() {
        return chance;
    }

    public void setChance(Chance chance) {
        this.chance = chance;
    }
}
