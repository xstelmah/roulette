package beans;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dao.UserService;
import service.logic.SteamOpenID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);

    private User user;

    private static final String callbackPage = "http://localhost:8080/faces/steamAuth.xhtml";

    private static final String okAuthRedirect = "userLogin.xhtml";

    private static final String failAuthRedirect = "guestPlayGame.xhtml";

    @ManagedProperty(value = "#{steamOpenId}")
    private SteamOpenID steamOpenID;


    public String goToSteam() {
        LOG.info("TRY LOGIN FROM STEAM USER");
        return steamOpenID.login(callbackPage);
    }

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
                    // create user
                    // update info + create balance
                }
                else {
                    user = currentUser;
                    externalContext.redirect(okAuthRedirect);
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


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setSteamOpenID(SteamOpenID steamOpenID) {
        this.steamOpenID = steamOpenID;
    }
}
