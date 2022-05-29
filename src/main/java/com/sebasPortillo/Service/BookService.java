package com.sebasPortillo.Service;

import com.sebasPortillo.Model.Author;
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

    public List<Book> findBookByEstado(int estado, long idUser){
        return repository.findBookByEstado(estado,idUser);
    }

    public List<Book> findBookByUser(long idUser){
        return repository.findBookByUser(idUser);
    }


    public boolean save (Book book){
        try {
            repository.save(book);
            return  true;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace().toString());
            return false;
        }
    }

    public void deleteById(long id){
        deleteBookReferences(id);
        repository.deleteById(id);
    }

    public List<Book> findByTittle(String tittle){
        return repository.findBookByTittle(tittle);
    }

    private void deleteBookReferences(long id){
        repository.deleteBookReferencesUserBook(id);
        repository.deleteBookReferencesAuthorBook(id);
        repository.deleteBookReferencesGenderBook(id);
        repository.deleteBookReferencesCommentBook(id);
    }

    public List<Book> findByAuthor(long idAuthor){
        return repository.findByAuthor(idAuthor);
    }

    public List<Book> findByGender(long idGender){
        return repository.findByGender(idGender);
    }

    public Book findByISBN(String isbn){
        return repository.findByISBN(isbn);
    }
}
