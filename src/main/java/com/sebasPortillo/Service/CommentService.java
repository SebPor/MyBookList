package com.sebasPortillo.Service;

import com.sebasPortillo.Model.Comment;
import com.sebasPortillo.Respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> findAll(){

        return repository.findAll();
    }

    public Comment findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public boolean save(Comment comment){

        try {
            repository.save(comment);
            return true;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace().toString());
            return false;
        }
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Comment> findCommentByBookId(long id){
        return repository.findCommentsByBookId(id);
    }
}
