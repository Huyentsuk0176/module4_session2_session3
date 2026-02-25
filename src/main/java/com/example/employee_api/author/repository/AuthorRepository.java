package com.example.employee_api.author.repository;
import com.example.employee_api.author.model.Author;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
@Repository
public class AuthorRepository {
    private final List<Author>
    authors = new ArrayList<>();
    private AuthorRepository(){
        authors.add(new Author(1,"pham thi huyen","h@gmail.com"));
        authors.add(new Author(2,"nguyen van A","a@gmail.com"));
        authors.add(new Author(3,"do gia huy","h@gmail.com"));

    }
    public List<Author> findAll(){
        return authors;
    }
    public void save(Author author){
        authors.add(author);
    }
}
