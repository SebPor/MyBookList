package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "Select * from libro where isbn = :isbn", nativeQuery = true)
    public Book findByISBN(String isbn);

    @Query(value = "select l.* from libro l, autor_libro al where l.id = al.fk_libro  and al.fk_autor = :idAuthor", nativeQuery = true)
    public List<Book> findByAuthor(int idAuthor);

    @Query(value = "select l.* from libro l, generos_libro gl where l.id = gl.fk_libro and gl.fk_genero = :idGender", nativeQuery = true)
    public List<Book> findByGender(int idGender);
}
