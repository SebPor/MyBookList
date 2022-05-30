package com.sebasPortillo.Service;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Model.DTOs.InBookDTO;
import com.sebasPortillo.Respository.BookRepository;
import com.sebasPortillo.Respository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenderService genderService;

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


    public boolean save (InBookDTO book){
        try {
            Book bookEntity = new Book();
            bookEntity.setId(0L);
            bookEntity.setISBN(book.getISBN());
            bookEntity.setPaginas(book.getPaginas());
            bookEntity.setTitulo(book.getTitulo());
            bookEntity.setSinopsis(book.getSinopsis());

            saveEntity(bookEntity);
            long id = repository.findLastBook().getId();

            String[] autores = book.getAuthor().split(",");
            for(int i = 0;i<autores.length;i++){
                long idAuthor = authorService.getId(autores[i]);
                repository.linkAuthor(id,idAuthor);
            }

            String[] generos = book.getGenders().split(",");
            for(int i = 0;i<generos.length;i++){
                long idGeneros = genderService.getId(generos[i]);
                repository.linkGender(id, idGeneros);
            }

            return  true;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace().toString());
            return false;
        }
    }

    public Book saveEntity(Book book){
        return repository.save(book);
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

    public List<Book> findBooksByAuthorName(String name){
        return repository.findBooksByAuthorName(name);
    }

    public List<Book> findBooksByGenderName(String name){
        return repository.findBooksByGenderName(name);
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

    public void addBookToList(long idUser, long idBook, int idEstado){
        repository.addBookToList(idUser,idBook,idEstado);
    }
}
