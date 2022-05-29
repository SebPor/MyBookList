package com.sebasPortillo.Controller.API;

import com.sebasPortillo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentAPIController {

    @Autowired
    private CommentService commentService;
}
