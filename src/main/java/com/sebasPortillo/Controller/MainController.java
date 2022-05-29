package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Model.DTOs.AuthorDTO;
import com.sebasPortillo.Model.DTOs.BookDTO;
import com.sebasPortillo.Model.User;
import com.sebasPortillo.Service.AuthorService;
import com.sebasPortillo.Service.BookService;
import com.sebasPortillo.Service.GenderService;
import com.sebasPortillo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenderService genderService;

    @GetMapping({"/","/index","/inicio"})
    public String index(Model model){

        return "index";
    }

    @GetMapping("/login")
    public String logIn(){
        return "login";
    }

    @PostMapping("/checkLogin")
    public String checkLogin(@ModelAttribute(value = "user") User user){
        System.out.println(user);
        return "redirect:/login";
    }

    @GetMapping("/singin")
    public String singin(){

        return "singin";
    }

    @PostMapping("/checkSingin")
    public String checkSingin(@ModelAttribute(value = "user") User user){
        System.out.println(user);
        return "redirect:/singin";
    }

    @GetMapping("/book/{idBook}")
    public String getBookById(@PathVariable(name = "idBook") String idBook, Model model){
        long id = Long.parseLong(idBook);
        Book book = bookService.findById(id);

        if(book == null){
            return "redirect:error";
        }

        model.addAttribute("book",mapBookDTO(book));
        return "book";
    }

    @GetMapping("/author/{idAuthor}")
    public String getAuthorById(@PathVariable(name = "idAuthor")String idAuthor, Model model){
        long id = Long.parseLong(idAuthor);
        Author author = authorService.findById(id);

        if(author == null){
            return "redirect:error";
        }

        model.addAttribute("author", mapAuthorDTO(author));
        return "author";
    }

    private BookDTO mapBookDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitulo(book.getTitulo());
        bookDTO.setPaginas(book.getPaginas());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setImg(book.getImg());
        bookDTO.setSinopsis(book.getSinopsis());
        bookDTO.setAuthors(authorService.findAuthorByBook(book.getId()));
        bookDTO.setGenders(genderService.findGenderByBook(book.getId()));

        return bookDTO;
    }

    private AuthorDTO mapAuthorDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setMuerte(author.getMuerte());
        authorDTO.setNacimiento(author.getNacimiento());
        authorDTO.setEdad();
        authorDTO.setNombre(author.getNombre());

        return authorDTO;
    }


}
