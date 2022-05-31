package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Model.DTOs.BookDTO;
import com.sebasPortillo.Model.DTOs.InBookDTO;
import com.sebasPortillo.Service.AuthorService;
import com.sebasPortillo.Service.BookService;
import com.sebasPortillo.Service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("bookCrud/{mode}")
    public String bookCrud(@PathVariable(name = "mode") String mode, Model model){
       if(mode.equals("insertar")){
           return "back/bookInsert";
       }
       model.addAttribute("books",mapBookDTO());
       if(mode.equals("borrar")){
           return "back/bookDelete";
       }

        return "back/bookVer";
    }

    @GetMapping("book/delete/{idBook}")
    public String bookDelete(@PathVariable(name = "idBook") String idBook){
        long id = Long.parseLong(idBook);
        bookService.deleteById(id);
        return "redirect:/back/bookCrud/borrar";
    }
    @PostMapping("book/insert")
    public String bookInsert(@ModelAttribute(value = "book") InBookDTO book){
        insertBook(book);
        return "redirect:/back/bookCrud/insertar";
    }

    private List<BookDTO> mapBookDTO(){
        List<Book> bookList = bookService.findAll();
        List<BookDTO> books = new ArrayList<>(bookList.size());
        for(int i = 0;i<bookList.size();i++){
            Book book = bookList.get(i);
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitulo(book.getTitulo());
            bookDTO.setPaginas(book.getPaginas());
            bookDTO.setISBN(book.getISBN());
            bookDTO.setImg(book.getImg());
            bookDTO.setSinopsis(book.getSinopsis());
            bookDTO.setAuthors(authorService.findAuthorByBook(book.getId()));
            bookDTO.setGenders(genderService.findGenderByBookId(book.getId()));
            books.add(bookDTO);
        }

        return books;
    }

    private boolean insertBook(InBookDTO book){
        //No pueden haber 2 ISBN iguales
        if(bookService.findByISBN(book.getISBN()) != null){
            return false;
        }
        String[] autores = book.getAuthor().split(",");
        for (String autore : autores) {
            //Comprobamos que los autores existen
            if (!authorService.exists(autore)) {
                return false;
            }
        }
        String[] generos = book.getGenders().split(",");
        for (String genero : generos) {
            if (!genderService.exists(genero)) {
                return false;
            }
        }

        return bookService.save(book);
    }


}
