package com.sebasPortillo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @GetMapping({"/","/index","/inicio"})
    public String index(){


        return "index";
    }
}
