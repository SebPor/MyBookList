package com.sebasPortillo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @GetMapping({"/","/index","/inicio"})
    public String index(Model model){

        return "index";
    }

    public String logIn(Model model){

        return "login";
    }

    public String singId(Model model){

        return "singin";
    }
}
