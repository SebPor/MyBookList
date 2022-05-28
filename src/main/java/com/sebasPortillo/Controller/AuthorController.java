package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.User;
import com.sebasPortillo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("back/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("authorCrud/{mode}")
    public String authorCrud(@PathVariable(name = "mode") String mode, Model model){

        model.addAttribute("mode",mode);

        if(mode.equals("insertar")){
            return "back/authorInsert";
        }
        model.addAttribute("authors", authorService.findAll());

        if(mode.equals("ver")){
            return "back/authorVer";
        }
        return "back/authorDelete";
    }

    @GetMapping("author/delete/{idAuthor}")
    public String authorDelete(@PathVariable(name = "idAuthor") String idAuthor){
        long id = Long.parseLong(idAuthor);
        authorService.deleteById(id);

        return "redirect:/back/authorCrud/borrar";
    }

    @PostMapping("author/insert")
    public String authorInsert(@ModelAttribute(value = "user") User user){

        System.out.println(user);

        return "redirect:/back/authorCrud/insert";
    }
}
