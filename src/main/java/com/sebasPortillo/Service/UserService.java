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
        try {
            repository.save(user);
            return true;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace().toString());
            return false;
        }

    }

    public void delete(long id){
        deleteUserReferences(id);
        repository.deleteById(id);
    }

    private void deleteUserReferences(Long id){
        repository.deleteUserReferencesUserBook(id);
        repository.deleteUserReferencesComentario(id);
    }
}
