package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
