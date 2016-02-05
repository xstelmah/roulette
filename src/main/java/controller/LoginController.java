package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.dao.UserService;


@Controller
public class LoginController {

    @Autowired
    UserService userServiceImpl;


}
