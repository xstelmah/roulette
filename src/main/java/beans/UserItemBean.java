package beans;

import model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dao.BetService;
import service.dao.ItemService;
import service.dao.UserService;
import service.logic.GameLogicService;
import service.logic.ItemLogicService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserItemBean {

    private static final Logger LOG = LoggerFactory.getLogger(UserGameBean.class);

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    @ManagedProperty(value = "#{itemService}")
    private ItemService itemService;

    @ManagedProperty(value = "#{itemLogicService}")
    private ItemLogicService itemLogicService;

    private List<Integer> selectedItems;

    private List<Item> notTransItems;

    private List<Item> transItems;

    public UserItemBean() {
        LOG.info("UserItemBean created");
    }
    @PostConstruct
    private void postConstructor(){
        if (!(userBean == null || userBean.getUser() == null || userBean.getUser().getId() == null)) {
            notTransItems = itemService.getNotTransmittedItems(userBean.getUser());
            transItems = itemService.getTransmittedItems(userBean.getUser());
        }
    }

    public void updateItemsStatus() {

        if (userBean != null && userBean.getUser() != null) {
            itemLogicService.updateItems(selectedItems, userBean.getUser());
            postConstructor();
        }
    }


    public List<Item> getTransItems() {
        return transItems;
    }

    public void setTransItems(List<Item> transItems) {
        this.transItems = transItems;
    }

    public List<Item> getNotTransItems() {
        return notTransItems;
    }

    public void setNotTransItems(List<Item> notTransItems) {
        this.notTransItems = notTransItems;
    }

    public List<Integer> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Integer> selectedItems) {
        this.selectedItems = selectedItems;
    }


    public void setItemLogicService(ItemLogicService itemLogicService) {
        this.itemLogicService = itemLogicService;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}
