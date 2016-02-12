package beans;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);

    private User user;

    public UserBean() {
        LOG.info("UserBean created");
        user = new User();
    }

    public String checkUser() {
        String outcome = null;
        LOG.info("CheckUser");
        user = userService.getUserByLoginPassword(user.getLogin(), user.getPassword());
        if (user == null) {
            LOG.info("User not found");
            user = new User();
            sendMessage("Error", "Login or password incorrect");
        } else {
            user.setPassword(null);
            outcome = "playGame";
        }
        return outcome;
    }

    public void sendMessage(String header, String body) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, header, body));
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
