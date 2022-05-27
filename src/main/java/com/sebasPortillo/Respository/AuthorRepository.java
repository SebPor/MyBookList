package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query(value = "select a.* from  autor_libro al, autor a where :id = al.fk_libro and al.fk_autor = a.id",nativeQuery = true)
    public List<Author> findAuthorByBook(Long id);

    @Modifying
    @Query(value = "delete from autor_libro where fk_autor = :id", nativeQuery = true)
    public void deleteAuthorReferences(@Param("id") Long id);
}
