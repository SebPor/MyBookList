package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.User;
import com.sebasPortillo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("back/")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping({"userCrud","userCrud/{mode}"})
    public String userCurd(@PathVariable(name = "mode", required = false)String mode, Model model){
        if(mode == null){
            mode = "";
        }

        model.addAttribute("mode",mode);

        if(mode.equals("ver") || mode.equals("borrar")){
            List<User> users = userService.findAll();
            model.addAttribute("users",users);
        }
        return "userCrud";
    }

    @GetMapping("user/delete/{idUsuario}")
    public String userDelete(@PathVariable(name = "idUsuario")String idUsuario){
        long id = Long.parseLong(idUsuario);
        userService.delete(id);
        return "redirect:/back/userCrud/borrar";
    }
}
