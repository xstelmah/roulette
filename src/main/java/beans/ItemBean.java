package beans;

import model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.ItemService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(ItemBean.class);

    @ManagedProperty(value = "#{itemService}")
    private ItemService itemService;

    private String itemRarity = "";

    private Integer itemId;

    public ItemBean() {
    }


    public Item obtainClearItemByRarity() {
        Item item = itemService.getFreeItemByRarity(itemRarity);
        if (item == null) {
            LOG.info("founded zero items");
            return new Item();
        }
        return item;
    }


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemRarity() {
        return itemRarity;
    }

    public void setItemRarity(String itemRarity) {
        this.itemRarity = itemRarity;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}
