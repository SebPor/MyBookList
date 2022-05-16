package com.sebasPortillo.Util;

import com.sebasPortillo.Model.Author;
import com.sebasPortillo.Model.Book;
import com.sebasPortillo.Model.DTOs.AuthorDTO;
import com.sebasPortillo.Model.DTOs.BookDTO;
import com.sebasPortillo.Model.DTOs.UserDTO;
import com.sebasPortillo.Model.User;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public BookDTO mapBookDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        return bookDTO;
    }

    public AuthorDTO mapAuthorDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();

        return authorDTO;
    }

    public UserDTO mapUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        return userDTO;
    }
}
