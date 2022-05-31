package com.sebasPortillo.Service;

import com.sebasPortillo.Model.Gender;
import com.sebasPortillo.Respository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderRepository repository;


    public List<Gender> findAll(){
        return repository.findAll();
    }

    public Gender findById(long idGender){
        return repository.findById(idGender).orElse(null);
    }

    public List<Gender> findGenderByBookId(long idBook){

        return repository.findGenderByBookId(idBook);
    }

    public boolean exists(String name){
        return repository.exists(name) != null;
    }

    public long getId(String name){
        return repository.getId(name);
    }

    public boolean save(Gender gender){
        try{
            repository.save(gender);
            return true;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace().toString());
            return false;
        }
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }
}
