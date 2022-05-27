package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("back/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping({"authorCrud","authorCrud/{mode}"})
    public String authorCrud(@PathVariable(name = "mode", required = false) String mode, Model model){
        if(mode == null){
            mode = "";
        }
        model.addAttribute("mode",mode);

        if(mode.equals("ver") || mode.equals("borrar")){
            List<Author> authors = authorService.findAll();
            model.addAttribute("authors",authors);
        }
        return "authorCrud";
    }

    @GetMapping("author/delete/{idAuthor}")
    public String authorDelete(@PathVariable(name = "idAuthor") String idAuthor){
        long id = Long.parseLong(idAuthor);
        authorService.deleteById(id);

        return "redirect:/back/authorCrud/borrar";
    }
}
