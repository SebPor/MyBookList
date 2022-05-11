package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "Select * from libro where isbn like ?1", nativeQuery = true)
    public Book findByISBN(String isbn);
}
