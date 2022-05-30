package com.sebasPortillo.Controller.API;

import com.sebasPortillo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentAPIController {

    @Autowired
    private CommentService commentService;

    @GetMapping("get/comment/{idUser}")
    public String getCommentsByUserId(@PathVariable(name = "idUser") String idUser){

        return "";
    }

    @GetMapping("get/comment/{idBook}")
    public String getCommentsByBook(@PathVariable(name = "idBook") String idBook){
        return "";
    }
}
