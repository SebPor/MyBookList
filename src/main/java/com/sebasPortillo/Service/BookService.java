package com.sebasPortillo.Service;

import com.sebasPortillo.Respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;
}
