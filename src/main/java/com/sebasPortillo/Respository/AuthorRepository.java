package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
