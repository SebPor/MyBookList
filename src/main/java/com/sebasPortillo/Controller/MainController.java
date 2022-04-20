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

    @GetMapping("/login")
    public String logIn(Model model){

        return "login";
    }

    @GetMapping("/singin")
    public String singId(Model model){

        return "singin";
    }
}
