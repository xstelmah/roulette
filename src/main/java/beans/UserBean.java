package beans;

import model.Balance;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dao.BalanceService;
import service.dao.UserService;
import service.logic.SteamOpenID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{balanceService}")
    private BalanceService balanceService;

    private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);

    private User user;

    private static final String callbackPage = "http://localhost:8088/faces/steamAuth.xhtml";

    private static final String okAuthRedirect = "userPlayGame.xhtml";

    private static final String failAuthRedirect = "guestPlayGame.xhtml";

    @ManagedProperty(value = "#{steamOpenId}")
    private SteamOpenID steamOpenID;


    public String goToSteam() {
        LOG.info("TRY LOGIN FROM STEAM USER");
        return steamOpenID.login(callbackPage);
    }

    //@Transactional with args
    public void checkUser() {
        Map<String, String> authMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String steamId = steamOpenID.verify(callbackPage, authMap);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            if (steamId == null)
                externalContext.redirect(failAuthRedirect);
            else {
                User currentUser = userService.getUserBySteamId(steamId);
                if (currentUser == null) {

                    User newUser = new User();
                    String tempLogin = "qwe123";
                    newUser.setSteamLogin(tempLogin);
                    newUser.setSteamId(steamId);
                    userService.insertUser(newUser);

                    Balance newBalance = new Balance();
                    newBalance.setValue(0.0);
                    newBalance.setUser(newUser);
                    balanceService.insertBalance(newBalance);

                    newUser.setBalance(newBalance);
                    userService.updateUser(newUser);

                    user = newUser;
                    externalContext.redirect(okAuthRedirect);

                    LOG.info("User created");
                } else {
                    user = currentUser;
                    externalContext.redirect(okAuthRedirect);
                    LOG.info("User already exist");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserBean() {
        LOG.info("UserBean created");
        user = new User();
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setSteamOpenID(SteamOpenID steamOpenID) {
        this.steamOpenID = steamOpenID;
    }

    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

}
