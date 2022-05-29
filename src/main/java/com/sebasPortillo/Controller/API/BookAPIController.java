package com.sebasPortillo.Controller.API;

import com.sebasPortillo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAPIController {

    @Autowired
    private BookService bookService;
}
