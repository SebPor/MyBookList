package com.sebasPortillo.Service;


import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Respository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    /**
     * Busca todos los autores que hay
     * @return
     */
    public List<Author> findAll(){
        return repository.findAll();
    }

    /**
     * Saca el autor con el ID
     * @param id El id del autor a buscar
     * @return Devuelve el autor, en caso de no encontrarlo devuelve Null
     */
    public Author findById(Long id){
        return repository.findById(id).orElse(null);
    }


    public boolean save(Author author){
        try {
            repository.save(author);
            return true;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace().toString());
            return false;
        }
    }

    public boolean exists(String name){
        return repository.exists(name) != null;
    }

    public long getId(String name){
        return repository.getID(name);
    }

    public List<Author> findByName(String name){

        return repository.findAuthorByName(name);
    }

    public void deleteById(Long id){
        repository.deleteAuthorReferences(id);
        repository.deleteById(id);

    }

    public List<Author> findAuthorByBook(long idBook){
        return repository.findAuthorByBook(idBook);
    }
}
