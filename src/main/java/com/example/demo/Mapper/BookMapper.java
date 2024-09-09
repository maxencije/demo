package com.example.demo.Mapper;

import com.example.demo.DTO.BookDTO;
import com.example.demo.Entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);
    List<BookDTO> toDTO(List<Book> books);
    List<Book> toEntity(List<BookDTO> books);
}