package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GenderRepository extends JpaRepository<Gender,Long> {

    @Query(value = "select g.* from genero g, generos_libro gl where g.id = gl.fk_genero and gl.fk_libro = :idBook", nativeQuery = true)
    public List<Gender> findGenderByBook(long idBook);
}
