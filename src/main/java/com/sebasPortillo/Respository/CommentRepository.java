package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "select c.* from comentario c where :id = c.fk_libro", nativeQuery = true)
    public List<Comment> findCommentsByBookId(long id);

}
