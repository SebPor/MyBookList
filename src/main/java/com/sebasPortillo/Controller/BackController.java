package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Gender;
import com.sebasPortillo.Respository.GenderRepository;
import com.sebasPortillo.Service.AuthorService;
import com.sebasPortillo.Service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("back/")
public class BackController {

    @Autowired
    private GenderService genderService;

    @Autowired
    private AuthorService authorService;

    //Controladores de los libros
    @GetMapping({"bookCrud","bookCrud/{mode}"})
    public String bookCrud(@PathVariable(name = "mode", required = false) String mode, Model model){
        if(mode == null){
            mode = "";
        }
        model.addAttribute("mode",mode);
        return "bookCrud";
    }

    //Controladores de los Autores
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
        long id = Integer.parseInt(idAuthor);
        authorService.deleteById(id);

        return "redirect:/back/authorCrud/borrar";
    }

    //Controladores de los comentarios
    @GetMapping({"commentCurd","commentCrud/{mode}"})
    public String commentCrud(@PathVariable(name = "mode", required = false) String mode, Model model){
        if(mode == null){
            mode = "";
        }
        model.addAttribute("mode",mode);
        return "commentCrud";
    }

    //Controladores de los Genereos

    @GetMapping({"genderCrud","genderCrud/{mode}"})
    public String genderCrud(@PathVariable(name = "mode", required = false) String mode, Model model){
        if(mode == null){
            mode = "";
        }
        model.addAttribute("mode",mode);

        if(mode.equals("ver") || mode.equals("borrar")){
            List<Gender> genders = genderService.findAll();
            model.addAttribute("genders",genders);
        }
        return "genderCrud";
    }

    @GetMapping("gender/delete/{idGender}")
    public String genderDelete(@PathVariable(name = "idGender")String idGender){
        long id = Integer.parseInt(idGender);
        genderService.deleteById(id);

        return "redirect:/back/genderCrud/borrar";
    }
}
