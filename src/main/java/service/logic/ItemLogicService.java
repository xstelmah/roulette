package service.logic;

import model.Item;
import model.ItemStatus;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import service.dao.ItemService;
import service.dao.UserService;

import java.util.List;

@Service
public class ItemLogicService {

    private static final Logger LOG = LoggerFactory.getLogger(ItemLogicService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

//    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updateItems(List<Integer> ids, User user) {
        user = userService.getUserById(user.getId());
        for (Integer id : ids) {
            for (Item item : user.getItems()) {
                if (item.getId().equals(id)) {
                    item.setStatus(ItemStatus.TRANSMITTED);
                    itemService.updateItem(item);
                }
            }
        }
    }
}
