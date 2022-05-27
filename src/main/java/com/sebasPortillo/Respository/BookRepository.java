package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "Select * from libro where isbn = :isbn", nativeQuery = true)
    public Book findByISBN(String isbn);

    @Query(value = "select l.* from libro l, autor_libro al where l.id = al.fk_libro  and al.fk_autor = :idAuthor", nativeQuery = true)
    public List<Book> findByAuthor(int idAuthor);

    @Query(value = "select l.* from libro l, generos_libro gl where l.id = gl.fk_libro and gl.fk_genero = :idGender", nativeQuery = true)
    public List<Book> findByGender(int idGender);

    @Modifying
    @Query(value =  "delete from autor_libro al where al.fk_libro = :id", nativeQuery = true)
    public void deleteBookReferencesAuthorBook(@Param("id") long id);

    @Modifying
    @Query(value = "delete from generos_libro gl where gl.fk_libro = :id", nativeQuery = true)
    public void deleteBookReferencesGenderBook(@Param("id") long id);

    @Modifying
    @Query(value = "delete from usuario_libro ul where ul.fk_libro = :id", nativeQuery = true)
    public void deleteBookReferencesUserBook(@Param("id") long id);

    @Modifying
    @Query(value = "delete from comentario where fk_libro = 1", nativeQuery = true)
    public void deleteBookReferencesCommentBook(@Param("id") long id);
}
