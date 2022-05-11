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

    /**
     * Guarda el autor
     * @param author El autor a guardar
     * @return True si se ha guardado bien, False si no
     */
    public Author save(Author author){

        return  repository.save(author);
    }

    /**
     *
     * Edita el autor con el id asignado
     * @param author El nuevo autor
     * @param id El id del autor que se quiere cambiar
     * @return True si se ha editado bien, False si no
     */
    public Author edit(Author author, Long id){
        Author result = findById(id);
        if(result != null && !result.equals(author)){
            repository.delete(result);
            repository.save(author);
        }
        return author;
    }
}
