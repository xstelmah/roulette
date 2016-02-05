package beans;

import model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.ItemService;

import javax.faces.bean.SessionScoped;

@Component(value = "itemBean")
@SessionScoped
public class ItemBean {
    private static final Logger LOG = LoggerFactory.getLogger(ItemBean.class);

    @Autowired
    private ItemService itemService;

    private String itemRarity = "";

    private Integer itemId;

    public ItemBean() {
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

    public Item obtainClearItemByRarity() {
        Item item = itemService.getFreeItemByRarity(itemRarity);
        if (item == null) {
            LOG.info("founded zero items");
            return new Item();
        }
        return item;
    }

    public void createItems() {
//        List<String> rarities = new ArrayList<>();
//        rarities.add("common");
//        rarities.add("uncommon");
//        rarities.add("rare");
//        rarities.add("mythical");
//        rarities.add("immortal");
//        rarities.add("legendary");
//        rarities.add("arcana");
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < rarities.size(); j++) {
//                Integer itemId = i * rarities.size() + j;
//                Integer botId = (Math.random() >= 0.5) ? 1 : 0;
//                String type = "item";
//                String name = "item " + itemId;
//                String rarity = rarities.get(j);
//                itemService.insertItem(itemId, name, rarity, type, botId);
//            }
//        }
    }
}
