package com.sebasPortillo.Controller.API;

import com.sebasPortillo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAPIController {

    @Autowired
    private BookService bookService;


    @GetMapping("get/book")
    public String getBook(){
        return "";
    }

    @GetMapping("get/book/{idBook}")
    public String getBookById(@PathVariable(name = "idBook") String idBook){
        return "";
    }

    @GetMapping("get/book/{tittle}")
    public String getBooksByTittle(@PathVariable(name = "tittle") String tittle){

        return "";
    }
}
