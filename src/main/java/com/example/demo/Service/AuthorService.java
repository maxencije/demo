package com.example.demo.Service;

import com.example.demo.APIExceptionHandler.APIException;
import com.example.demo.DTO.AuthorDTO;
import com.example.demo.Entity.Author;
import com.example.demo.Mapper.AuthorMapper;
import com.example.demo.Repository.AuthorRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthorService {

    private AuthorRepo authorRepo;
    private AuthorMapper authorMapper;

    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        authorRepo.save(author);
        return authorDTO;
    }

    public AuthorDTO getAuthorById(Long id) throws APIException {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new APIException("Author not found",
                    HttpStatus.NOT_FOUND,
                    ZonedDateTime.now()));
        return authorMapper.toDto(author);
    }

    public AuthorDTO deleteAuthor(Long id) throws APIException {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new APIException("Author not found",
                        HttpStatus.NOT_FOUND,
                        ZonedDateTime.now()));
        authorRepo.delete(author);
        return authorMapper.toDto(author);
    }
}
