package com.example.employee_api.author.controller;
import com.example.employee_api.author.model.Author;
import com.example.employee_api.author.service.AuthorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }
    //Get
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    //Post
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return
                authorService.createAuthor(author);
    }
}
