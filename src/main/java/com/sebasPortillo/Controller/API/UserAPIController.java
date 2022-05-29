package com.sebasPortillo.Controller.API;

import com.sebasPortillo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPIController {

    @Autowired
    private UserService userService;
}
