package com.sebasPortillo.Service;

import com.sebasPortillo.Model.Comment;
import com.sebasPortillo.Respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> findAll(){

        return repository.findAll();
    }

    public Comment findById(Integer id){
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

    public boolean delete(Comment comment){
        try {
            repository.delete(comment);
            return true;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace().toString());
            return false;
        }
    }
}
