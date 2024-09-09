package com.example.demo.DTO;

import com.example.demo.Entity.Author;
import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private Author author;
}