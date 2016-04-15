package beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class TestBean implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(TestBean.class);

    private String checked1 = "checked";

    public String getChecked1() {
        LOG.info("GET CHECKED1 '{}'", checked1);
        return checked1;
    }

    public void setChecked1(String checked1) {
        LOG.info("SET CHECKED1 '{}'", checked1);
        this.checked1 = checked1;
    }

    public void change(ValueChangeEvent event) {

    }
}
