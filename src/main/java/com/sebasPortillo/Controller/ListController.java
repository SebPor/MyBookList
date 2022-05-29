package com.sebasPortillo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping("/list")
    public String list(){

        return "main_list";
    }
}
