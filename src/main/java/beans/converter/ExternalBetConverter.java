package beans.converter;

import model.Bet;
import model.ItemRarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

//@FacesConverter("externalBetConverter")
@Service(value = "externalBetConverter")
public class ExternalBetConverter implements Converter {

    private static final Logger LOG = LoggerFactory.getLogger(ExternalBetConverter.class);

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        LOG.info("Start convert string:'"+value+"' to object");
        if (value == null) {
            LOG.error("Can't convert, Value is null");
            return null;
        }
        String[] values = value.split(" ");
        Bet externalBet = new Bet(666.0f,ItemRarity.ARCANA);
        if (values.length != 2) {
            LOG.error("BAD CONVERTED INFO");
            return null;
        }
        try {
            Float bet = Float.parseFloat(values[0]);
            ItemRarity itemRarity = ItemRarity.valueOf(values[1]);
            if (itemRarity == null) {
                LOG.error("Can't convert to ItemRarity");
                return null;
            }
            externalBet = new Bet(bet, itemRarity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("End of convert to obj, info: "+externalBet.toString());
        return (Bet) externalBet;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
        LOG.info("Bet to spring ");
        if (obj == null)
        {
            LOG.error("object is null");
            return null;
        }

        if (obj instanceof Bet) {
            return ((Bet) obj).getValue() + " " + ((Bet) obj).getRarity().toString();
        } else {
            LOG.error("Can't convert, object not Bet");
            return null;
        }
    }
}
