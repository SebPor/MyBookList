package com.sebasPortillo.Controller;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Model.DTOs.ListDTO;
import com.sebasPortillo.Model.User;
import com.sebasPortillo.Service.AuthorService;
import com.sebasPortillo.Service.BookService;
import com.sebasPortillo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserService userService;



    @GetMapping({"/list/{idUser}", "/list/{idUser}/{idEstado}"})
    public String list(@PathVariable(name = "idUser") String idUser, @PathVariable(name = "idEstado", required = false) String idEstado, Model model){


        long idUsuario = Long.parseLong(idUser);
        User user = userService.findById(idUsuario);
        if(user == null){
            return "redirect:/error";
        }

        if(idEstado == null){
            idEstado = "0";
        }
        int estado = Integer.parseInt(idEstado);
        model.addAttribute("books", masListDTOs(idUsuario,estado));
        model.addAttribute("user",user);
        switch (estado){
            case 0:
                model.addAttribute("seleccion","Todos");
                break;
            case 1:
                model.addAttribute("seleccion","Leyendo");
                break;
            case 2:
                model.addAttribute("seleccion", "Pendientes");
                break;
            case 3:
                model.addAttribute("seleccion", "Leidos");
                break;
        }
        return "main_list";
    }

    private List<ListDTO> masListDTOs(long idUser, int estado){
        List<Book> books;

        if(estado > 0){
            books = bookService.findBookByEstado(estado,idUser);
        }else{
            books = bookService.findBookByUser(idUser);
        }

        List<ListDTO> listDTOS = new ArrayList<>(books.size());

        for(int i = 0;i<books.size();i++){
            ListDTO list = new ListDTO();
            Book book = books.get(i);

            list.setId(i+1);
            list.setTitulo(book.getTitulo());
            list.setPaginas(book.getPaginas());
            list.setIdBook(book.getId());

            List<Author> authors = authorService.findAuthorByBook(book.getId());
            if(authors.size() == 1){
                list.setAuthor(authors.get(0).getNombre());
                list.setIdAuthor(authors.get(0).getId());
            }else{
                StringBuilder s = new StringBuilder();
                for(Author a : authors){
                    s.append(a.getNombre()).append(", ");
                }
                list.setAuthor(s.toString());
                list.setIdAuthor(-1);
            }
            listDTOS.add(list);
        }

        return listDTOS;
    }
}
