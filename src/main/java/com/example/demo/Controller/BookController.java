package com.example.demo.Controller;

import com.example.demo.APIExceptionHandler.APIException;
import com.example.demo.DTO.BookDTO;
import com.example.demo.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.saveBook(bookDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) throws APIException {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.FOUND);
    }

    @GetMapping("/{title}")
    public ResponseEntity<BookDTO> getBookByTitle(@PathVariable String title) throws APIException {
        return new ResponseEntity<>(bookService.getBookByTitle(title), HttpStatus.FOUND);
    }

    @GetMapping("/author/{name}")
    public ResponseEntity<List<BookDTO>> getAllBooksByAuthor(@PathVariable String name) {
        return new ResponseEntity<>(bookService.getBooksByAuthor(name), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable Long id) throws APIException {
        return new ResponseEntity<>(bookService.deleteBookById(id), HttpStatus.FOUND);
    }
}