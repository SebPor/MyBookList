package com.sebasPortillo.Service;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.User;
import com.sebasPortillo.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){

        return repository.findAll();
    }

    public User findById(Long id){
       return repository.findById(id).orElse(null);
    }

    public boolean save(User user){

        return false;
    }

    public boolean edit(User user){

        return false;
    }
}
