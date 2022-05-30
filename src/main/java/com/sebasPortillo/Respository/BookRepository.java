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
    public List<Book> findByAuthor(long idAuthor);

    @Query(value = "select l.* from libro l, generos_libro gl where l.id = gl.fk_libro and gl.fk_genero = :idGender", nativeQuery = true)
    public List<Book> findByGender(long idGender);

    @Query(value = "select l.* from libro l, usuario_libro ul where ul.fk_usuario = :idUser and ul.fk_estado = :estado and l.id = ul.fk_libro", nativeQuery = true)
    public List<Book> findBookByEstado(int estado, long idUser);

    @Query(value = "select l.* from libro l, usuario_libro ul where ul.fk_libro = l.id and ul.fk_usuario = :idUser", nativeQuery = true)
    public List<Book> findBookByUser(long idUser);

    @Query(value = "select * from libro l where l.titulo like %:tittle%", nativeQuery = true)
    public List<Book> findBookByTittle(@Param("tittle") String tittle);

    @Query(value = "select * from libro l order by id desc limit 1", nativeQuery = true)
    public Book findLastBook();

    @Query(value = "select l.* from libro l, autor_libro al, autor a where l.id = al.fk_libro and al.fk_autor = a.id and a.nombre like %:name%", nativeQuery = true)
    public List<Book> findBooksByAuthorName(@Param("name") String name);

    @Query(value = "select l.* from libro l, generos_libro gl, genero g where l.id = gl.fk_libro and gl.fk_genero = g.id and g.nombre like %:name%", nativeQuery = true)
    public List<Book> findBooksByGenderName(@Param("name") String name);

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

    @Modifying
    @Query(value = "insert into autor_libro (fk_autor, fk_libro) values (:idAuthor,:idBook)", nativeQuery = true)
    public void linkAuthor(long idBook, long idAuthor );

    @Modifying
    @Query(value = "insert into generos_libro (fk_libro, fk_genero) values (:idBook,:idGender)", nativeQuery = true)
    public void linkGender(long idBook, long idGender);

    @Modifying
    @Query(value = "insert into usuario_libro (fk_usuario, fk_libro, fk_estado) values (:idUser,:idBook,:idEstado)", nativeQuery = true)
    public void addBookToList(long idUser, long idBook, int idEstado);
}
