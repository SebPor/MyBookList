package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query(value = "select a.* from  autor_libro al, autor a where :id = al.fk_libro and al.fk_autor = a.id",nativeQuery = true)
    public List<Author> findAuthorByBook(Long id);
}
