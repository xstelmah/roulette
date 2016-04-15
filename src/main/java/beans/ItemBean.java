package beans;

import model.Game;
import model.Item;
import model.ItemRarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.ItemService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(ItemBean.class);

    @ManagedProperty(value = "#{itemService}")
    private ItemService itemService;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;


    private Integer itemId;

    public ItemBean() {
    }

    private Integer countItemByRarity(ItemRarity rarity) {
        if (userBean == null || userBean.getUser() == null || userBean.getUser().getGames() == null) {
            return null;
        }
        Integer value = 0;
        List<Game> games = userBean.getUser().getGames();
        for (Game game : games) {
            Item item = game.getItem();
            if (item == null) return null;
            if (item.getRarity() == rarity) {
                value++;

            }
        }
        return value;
    }

    public Integer countItemByRarityCommon() {
        return countItemByRarity(ItemRarity.COMMON);
    }
    public Integer countItemByRarityUncommon() {
        return countItemByRarity(ItemRarity.UNCOMMON);
    }
    public Integer countItemByRarityRare() {
        return countItemByRarity(ItemRarity.RARE);
    }
    public Integer countItemByRarityMythical() {
        return countItemByRarity(ItemRarity.MYTHICAL);
    }
    public Integer countItemByRarityImmortal() {
        return countItemByRarity(ItemRarity.IMMORTAL);
    }
    public Integer countItemByRarityLegendary() {
        return countItemByRarity(ItemRarity.LEGENDARY);
    }
    public Integer countItemByRarityArcana() {
        return countItemByRarity(ItemRarity.ARCANA);
    }


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
