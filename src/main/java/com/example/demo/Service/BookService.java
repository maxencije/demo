package com.example.demo.Service;

import com.example.demo.APIExceptionHandler.APIException;
import com.example.demo.DTO.BookDTO;
import com.example.demo.Entity.Book;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.Repository.BookRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BookService {

    private BookRepo bookRepo;
    private BookMapper bookMapper;

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        bookRepo.save(book);
        return bookDTO;
    }

    public List<BookDTO> getBooks() {
        return bookMapper.toDTO(bookRepo.findAll());
    }

    public BookDTO getBookById(Long id) throws APIException {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new APIException("Book not found",
                        HttpStatus.NOT_FOUND,
                        ZonedDateTime.now()));
        return bookMapper.toDTO(book);
    }

    public BookDTO getBookByTitle(String title) throws APIException {
        Book book = bookRepo.findBookByTitle(title)
                .orElseThrow(() -> new APIException("Book not found",
                        HttpStatus.NOT_FOUND,
                        ZonedDateTime.now()));
        return bookMapper.toDTO(book);
    }

    public BookDTO deleteBookById(Long id) throws APIException {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new APIException("Book not found",
                        HttpStatus.NOT_FOUND,
                        ZonedDateTime.now()));
        bookRepo.deleteById(id);
        return bookMapper.toDTO(book);
    }

    public List<BookDTO> getBooksByAuthor(String name) {
        List<Book> books = bookRepo.findByAuthorName(name);
        return bookMapper.toDTO(books);
    }
}
