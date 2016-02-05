package service.dao;

import model.Item;
import model.ItemRarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ItemRepository;

import java.util.List;

@Service(value = "itemService")
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item getItemById(Integer id) {
        return itemRepository.getItemById(id);
    }

    public List<Item> getItemsByUserId(Integer id) {
        return itemRepository.getItemsByUserId(id);
    }

    public List<Item> getItemsByGameId(Integer id) {
        return itemRepository.getItemsByGameId(id);
    }

    public List<Item> getItemsByBotId(Integer id) {
        return itemRepository.getItemsByBotId(id);
    }

    public Item getFreeItemByRarity(String rarity) {
        return itemRepository.getFreeItemByRarity(rarity);
    }

    public void updateGameAndUserInItem(Integer gameId, Integer userId, Integer itemId) {
        itemRepository.updateGameAndUserInItem(gameId, userId, itemId);
    }

    public void insertItem(Integer id, String name, String rarity, String type, Integer botId) {
        itemRepository.insertItem(id, name, rarity, type, botId);
    }
}
