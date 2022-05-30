package com.sebasPortillo.Controller.API;

import com.sebasPortillo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPIController {

    @Autowired
    private UserService userService;

    @GetMapping("get/user/{idUser}")
    public String getUserById(@PathVariable(name = "idUser") String idUser){

        return "";
    }
}
