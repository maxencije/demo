package com.example.demo.Controller;

import com.example.demo.APIExceptionHandler.APIException;
import com.example.demo.DTO.AuthorDTO;
import com.example.demo.Service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @PostMapping("/author")
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorService.addAuthor(authorDTO), HttpStatus.CREATED);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) throws APIException {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<AuthorDTO> deleteAuthor(@PathVariable Long id) throws APIException {
        return new ResponseEntity<>(authorService.deleteAuthor(id), HttpStatus.OK);
    }
}
