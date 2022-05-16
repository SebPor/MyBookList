package com.sebasPortillo.Controller;

import com.sebasPortillo.Respository.UserRepository;
import com.sebasPortillo.Util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @GetMapping({"/","/index","/inicio"})
    public String index(Model model){

        return "index";
    }

    @PostMapping("/login")
    public String logIn(@RequestParam(name = "name") String name, @RequestParam(name = "pass") String pass, Model model){
        if(name.length() < 3){

            return "redirect:error";
        }

        return "login";
    }

    @GetMapping("/singin")
    public String singId(@RequestParam(name = "name") String name, @RequestParam(name = "pass") String pass, Model model){

        return "singin";
    }
}
