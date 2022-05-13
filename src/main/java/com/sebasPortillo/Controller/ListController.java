package com.sebasPortillo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {

    @GetMapping("/list")
    public String list(){

        return "main_list";
    }
    @GetMapping("/book/{id}")
    public String book(@RequestParam Integer id){

        return "book";
    }

    @GetMapping("/author/{id}")
    public String author(@RequestParam Integer id){

        return "author";
    }
}
