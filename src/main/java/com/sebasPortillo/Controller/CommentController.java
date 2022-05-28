package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Comment;
import com.sebasPortillo.Model.DTOs.CommentDTO;
import com.sebasPortillo.Service.BookService;
import com.sebasPortillo.Service.CommentService;
import com.sebasPortillo.Service.UserService;
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
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("commentCrud/{mode}")
    public String commentCrud(@PathVariable(name = "mode") String mode, Model model){
        model.addAttribute("mode",mode);

        if(mode.equals("insertar")){
            return "back/commentInsert";
        }

        model.addAttribute("comments",mapCommentDTO());

        if(mode.equals("ver")){
            return "back/commentVer";
        }
        return "back/commentDelete";
    }

    @GetMapping("comment/delete/{idComment}")
    public String deleteComment(@PathVariable(name = "idComment") String idComment){
        long id = Long.parseLong(idComment);
        commentService.deleteById(id);

        return "redirect:/back/commentCrud/borrar";
    }

    private List<CommentDTO> mapCommentDTO(){
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

        return comments;
    }
}
