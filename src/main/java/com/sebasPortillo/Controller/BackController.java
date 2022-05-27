package com.sebasPortillo.Controller;

import com.sebasPortillo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BackController {

    @Autowired
    private UserService userService;

    @GetMapping("back")
    private String index(Model model){
        model.addAttribute("users", userService.findAll());
        return "indexBack";
    }
}
