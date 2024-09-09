package com.example.demo.Mapper;

import com.example.demo.DTO.AuthorDTO;
import com.example.demo.DTO.BookDTO;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    Author toEntity(AuthorDTO authorDTO);
    AuthorDTO toDto(Author author);
    List<Book> toEntity(List<BookDTO> booksDTO);
    List<BookDTO> toDto(List<Book> books);
}
