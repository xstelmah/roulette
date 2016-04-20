package service.dao;

import model.Item;
import model.ItemRarity;
import model.User;
import org.apache.ibatis.annotations.Param;
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

    public Item getItemByGameId(Integer id) {
        return itemRepository.getItemByGameId(id);
    }

    public List<Item> getFreeItems(Integer count) {
        return itemRepository.getFreeItems(count);
    }

    public List<Item> getItemsByBotId(Integer id) {
        return itemRepository.getItemsByBotId(id);
    }

    public Item getFreeItemByRarity(ItemRarity rarity) {
        return itemRepository.getFreeItemByRarity(rarity);
    }

    public void updateItem(Item item) {
        itemRepository.updateItem(item);
    }

    public void insertItem(Item item) {
        itemRepository.insertItem(item);
    }

    public List<Item> getNotTransmittedItems(User user) {
        return itemRepository.getNotTransmittedItems(user);
    }

    public List<Item> getTransmittedItems(User user) {
        return itemRepository.getTransmittedItems(user);
    }
}
