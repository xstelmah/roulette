package beans.util.validators;

import beans.UserBean;
import model.User;
import service.dao.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class ChatLoginValidator implements Validator {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        String login = String.valueOf(value);
        if (value == null) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "",
                    "Логин не может быть пустым");
            throw new ValidatorException(message);
        }
        if (!login.matches("[a-zA-Z0-9_]{4,32}")) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "",
                    "Логин может состоять из английских букв, цифр и символа '_', длина от 4 до 32 символов");
            throw new ValidatorException(message);
        }
        User user = userService.getUserByChatLogin(login);
        if (user != null) {
            if (userBean.getUser() == null) return;
            if (userBean.getUser().getId() == user.getId()) return;
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "",
                    "Логин уже занят");
            throw new ValidatorException(message);
        }
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
