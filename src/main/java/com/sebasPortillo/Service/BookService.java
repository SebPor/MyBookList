package com.sebasPortillo.Service;

import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    /**
     * Devuelve una lista de todos los libros
     * @return
     */
    public List<Book> findAll(){

        return repository.findAll();
    }

    /**
     * Devuelve el libro con el id
     * @param id El id del libro
     * @return El libro, en caso de no encontralo develve null
     */
    public Book findById(Long id){

        return repository.findById(id).orElse(null);
    }

    /**
     * Guarda el libro
     * @param book El libro a guardar
     * @return True si se guarda bien, False si no
     */
    public boolean save (Book book){

        return false;
    }

    /**
     * Cambia el libro con el id proporcinado por el nuevo libro
     * @param book El nuevo libro
     * @param id El id del libro que se quiere cambiar
     * @return True si se edita correctamente, False si no
     */
    public boolean edit (Book book, Long id){

        return false;
    }
}
