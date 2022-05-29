package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.User;
import com.sebasPortillo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("back/")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("userCrud/{mode}")
    public String userCurd(@PathVariable(name = "mode")String mode, Model model){
        model.addAttribute("mode",mode);

        if(mode.equals("insertar")){
            return "back/userInsert";
        }

        model.addAttribute("users", userService.findAll());

        if(mode.equals("ver")){
            return "back/userVer";
        }

        return "back/userDelete";

    }

    @GetMapping("user/delete/{idUsuario}")
    public String userDelete(@PathVariable(name = "idUsuario")String idUsuario){
        long id = Long.parseLong(idUsuario);
        userService.delete(id);
        return "redirect:/back/userCrud/borrar";
    }

    @PostMapping("user/insert")
    public String authorInsert(@ModelAttribute(value = "user") User user){
        user.setId(0L);
        user.setRoles("ADMIN");
        userService.save(user);

        return "redirect:/back/userCrud/insert";
    }
}
