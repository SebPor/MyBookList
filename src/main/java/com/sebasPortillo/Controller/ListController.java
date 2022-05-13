package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Respository.AuthorRepository;
import com.sebasPortillo.Respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/list")
    public String list(){

        return "main_list";
    }
    @GetMapping("/book/{id}")
    public String getBookById(@RequestParam(name = "id") Long id, Model model){
        Book book = bookRepository.findById(id).orElse(null);

        if(book == null){
            return "redirect:error";
        }
        model.addAttribute("book",book);
        return "book";
    }

    @GetMapping("/author/{id}")
    public String getAuthorById(@RequestParam(name = "id") Long id, Model model){
        Author author = authorRepository.findById(id).orElse(null);

        if(author == null){
            return "redirect:error";
        }

        model.addAttribute("author", author);
        return "author";
    }
}
