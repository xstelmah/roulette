package beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.logic.SteamOpenID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean(name = "steamAuthBean")
@SessionScoped
public class SteamAuthBean {

    private static final Logger LOG = LoggerFactory.getLogger(SteamAuthBean.class);

    private static final String callbackPage = "http://localhost:8080/faces/steamAuth.xhtml";

    private String steamId ;

    @ManagedProperty(value = "#{steamOpenId}")
    private SteamOpenID steamOpenID;

    public SteamAuthBean() {
        LOG.info("SteamAuthBean created");
    }

    public String goToSteam() {
        LOG.info("TRY LOGIN FROM STEAM USER");
        return steamOpenID.login(callbackPage);
    }

    public void checkUser() {
        Map<String, String> authMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        steamId = steamOpenID.verify(callbackPage, authMap);
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public void setSteamOpenID(SteamOpenID steamOpenID) {
        this.steamOpenID = steamOpenID;
    }
}