package beans.util.validators;

import model.User;
import service.dao.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class SteamTradeUrlValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        String login = String.valueOf(value);
        if (value == null) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "",
                    "Ссылка на обмен не может быть пустой");
            throw new ValidatorException(message);
        }
        if  (!login.matches("https:\\/\\/steamcommunity.com\\/tradeoffer\\/new\\/\\?partner=.{8,13}&token=.{8,13}")) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "",
                    "Некорректная ссылка на обмен");
            throw new ValidatorException(message);
        }
    }

}