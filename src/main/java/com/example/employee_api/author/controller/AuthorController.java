package com.example.employee_api.author.controller;
import com.example.employee_api.author.model.Author;
import com.example.employee_api.author.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/{id}")
    public ResponseEntity<?>
    getById(@PathVariable Long id){
        Author author=authorService.findById(id);
        if (author==null){
            return
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body("author not found");
        }
        return
                ResponseEntity.ok(author);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>
    updateAuthor(@PathVariable("id") Long id,
                 @RequestBody Author request){
        Author updated= authorService.updateAuthor(id,request);
        if(updated==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
        return
                ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {

        // 1) check 404 trước
        Author existing = authorService.findById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }

        // 2) check rule Admin -> 400
        if (existing.getName() != null && existing.getName().equalsIgnoreCase("Admin")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Không được phép xóa tài khoản quản trị (Admin)");
        }

        // 3) xóa
        authorService.deleteAuthor(id);

        // trả 204 No Content (chuẩn REST) hoặc 200 OK tùy thầy
        return ResponseEntity.noContent().build(); // 204
        // hoặc: return ResponseEntity.ok("Deleted"); // 200
    }
}
