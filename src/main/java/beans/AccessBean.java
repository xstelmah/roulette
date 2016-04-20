package beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class AccessBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(AccessBean.class);

    private static final String failAuthUser = "guestPlayGame.xhtml";

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public void checkAccessByUser() {
        if (userBean == null || userBean.getUser() == null || userBean.getUser().getId() == null) {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            try {
                externalContext.redirect(failAuthUser);
            }
            catch (Exception e){
                LOG.error(e.getMessage());
            }
        }
    }

    public void checkAccessByAdmin() {

    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
