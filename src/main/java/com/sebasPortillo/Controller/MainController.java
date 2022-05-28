package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.User;
import com.sebasPortillo.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/","/index","/inicio"})
    public String index(Model model){

        return "index";
    }

    @GetMapping("/login")
    public String logIn(){
        return "login";
    }

    @PostMapping("/checkLogin")
    public String checkLogin(@ModelAttribute(value = "user") User user){
        System.out.println(user);
        return "redirect:/login";
    }

    @GetMapping("/singin")
    public String singin(){

        return "singin";
    }

    @PostMapping("/checkSingin")
    public String checkSingin(@ModelAttribute(value = "user") User user){

        System.out.println(user);
        return "redirect:/singin";
    }
}
