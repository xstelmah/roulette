package beans;

import model.Bot;
import model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dao.BotService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "botBean")
@SessionScoped
public class BotBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(BotBean.class);

    @ManagedProperty(value = "#{botService}")
    private BotService botService;

    private Integer botId;



    public List<Item> obtainBotItems() {
        if (botId == null) {
            LOG.info("Bot id is null!");
            return null;
        }

        if (botService == null) {
            LOG.info("Bot service is null!");
            return null;
        }
        Bot bot = botService.getBotById(botId);
        if (bot == null) {
            LOG.info("Not founded bot with id = " + botId);
            return null;
        }
        return bot.getItems();
    }

    public String obtainBotName() {
        if (botId == null) {
            LOG.info("Bot id is null!");
            return null;
        }

        if (botService == null) {
            LOG.info("Bot service is null!");
            return null;
        }
        Bot bot = botService.getBotById(botId);
        if (bot == null) {
            LOG.info("Not founded bot with id = " + botId);
            return null;
        }
        return bot.getName();
    }


    public Integer getBotId() {
        return botId;
    }

    public void setBotId(Integer botId) {
        this.botId = botId;
    }

    public BotService getBotService() {
        return botService;
    }

    public void setBotService(BotService botService) {
        this.botService = botService;
    }
}
