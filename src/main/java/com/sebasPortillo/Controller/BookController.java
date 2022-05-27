package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Model.DTOs.BookDTO;
import com.sebasPortillo.Service.AuthorService;
import com.sebasPortillo.Service.BookService;
import com.sebasPortillo.Service.GenderService;
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
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private AuthorService authorService;

    @GetMapping({"bookCrud","bookCrud/{mode}"})
    public String bookCrud(@PathVariable(name = "mode", required = false) String mode, Model model){
        if(mode == null){
            mode = "";
        }
        model.addAttribute("mode",mode);
        if(mode.equals("ver") || mode.equals("borrar")){
            List<Book> bookList = bookService.findAll();
            List<BookDTO> books = new ArrayList<>(bookList.size());
            for(int i = 0;i<bookList.size();i++){
                Book book = bookList.get(i);
                BookDTO bookDTO = new BookDTO();
                bookDTO.setId(book.getId());
                bookDTO.setTitulo(book.getTitulo());
                bookDTO.setPaginas(book.getPaginas());
                bookDTO.setIsbn(book.getISBN());
                bookDTO.setSinopsis(book.getSinopsis());
                bookDTO.setAuthors(authorService.findAuthorByBook(book.getId()));
                bookDTO.setGenders(genderService.findGenderByBook(book.getId()));
                books.add(bookDTO);
            }
            model.addAttribute("books",books);
        }

        return "bookCrud";
    }

    @GetMapping("book/delete/{idBook}")
    public String bookDelete(@PathVariable(name = "idBook") String idBook){
        long id = Long.parseLong(idBook);
        bookService.deleteById(id);
        return "redirect:/back/bookCrud/borrar";
    }

}
