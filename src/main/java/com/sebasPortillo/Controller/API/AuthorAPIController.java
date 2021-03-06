package com.sebasPortillo.Controller.API;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.sebasPortillo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorAPIController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("get/authors")
    public String getAuthors(){
        return "";
    }

    @GetMapping("get/author/{idAuthor}")
    public String getAuthorById(@PathVariable(name = "idAuthor") String idAuthor){

        return "";
    }
}
