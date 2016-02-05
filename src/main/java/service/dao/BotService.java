package service.dao;

import model.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BotRepository;


@Service(value = "botService")
public class BotService{


    @Autowired
    BotRepository botRepository;

    public Bot getBotById(Integer id) {
        return botRepository.getBotById(id);
    }
}
