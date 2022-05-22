package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Comment;
import com.sebasPortillo.Model.DTOs.CommentDTO;
import com.sebasPortillo.Model.Gender;
import com.sebasPortillo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("back/")
public class BackController {

    @Autowired
    private GenderService genderService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

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
        long id = Long.parseLong(idAuthor);
        authorService.deleteById(id);

        return "redirect:/back/authorCrud/borrar";
    }

    //Controladores de los comentarios
    @GetMapping({"commentCrud","commentCrud/{mode}"})
    public String commentCrud(@PathVariable(name = "mode", required = false) String mode, Model model){
        if(mode == null){
            mode = "";
        }
        model.addAttribute("mode",mode);

        if(mode.equals("ver") || mode.equals("borrar")){
            List<Comment> commentList = commentService.findAll();
            List<CommentDTO> comments = new ArrayList<>(commentList.size());
            for(int i = 0;i<commentList.size();i++){
                CommentDTO commentDTO = new CommentDTO();
                Comment comment = commentList.get(i);
                commentDTO.setId(comment.getId());
                commentDTO.setComment(comment.getComment());
                commentDTO.setUser(userService.findById(comment.getFk_usuario()).getNombre());
                commentDTO.setBook(bookService.findById(comment.getFk_libro()).getTitulo());
                comments.add(commentDTO);
            }
            model.addAttribute("comments",comments);
        }
        return "commentCrud";
    }

    @GetMapping("comment/delete/{idComment}")
    public String deleteComment(@PathVariable(name = "idComment") String idComment){
        long id = Long.parseLong(idComment);
        commentService.deleteById(id);

        return "redirect:/back/commentCrud/borrar";
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
        long id = Long.parseLong(idGender);
        genderService.deleteById(id);

        return "redirect:/back/genderCrud/borrar";
    }
}
