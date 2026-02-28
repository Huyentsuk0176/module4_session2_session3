package com.example.employee_api.author.service;
import com.example.employee_api.author.model.Author;
import java.util.List;
public interface AuthorService {
    List<Author> getAllAuthors();
    Author createAuthor(Author author);
    Author findById(Long id);
    Author updateAuthor(Long id, Author request);
}
