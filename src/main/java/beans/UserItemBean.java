package beans;

import model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dao.BetService;
import service.logic.GameLogicService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserItemBean {

    private static final Logger LOG = LoggerFactory.getLogger(UserGameBean.class);

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private List<String> selectedItems;

    public List<Item> currentItems() {
        if (userBean == null || userBean.getUser() == null || userBean.getUser().getId() == null) {
            return null;
        }
        return null;
    }


    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
