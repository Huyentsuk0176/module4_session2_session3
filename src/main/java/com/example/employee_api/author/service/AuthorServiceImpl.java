package com.example.employee_api.author.service;
import com.example.employee_api.author.model.Author;
import com.example.employee_api.author.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AuthorServiceImpl implements
AuthorService{
        private final
        AuthorRepository authorRepository;
        public
    AuthorServiceImpl(AuthorRepository authorRepository){
            this.authorRepository=authorRepository;
        }
        @Override
                public List<Author> getAllAuthors(){
            return authorRepository.findAll();
        }
        @Override
    public Author createAuthor(Author author){
            authorRepository.save(author);
            return author;
        }
    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);

    }
    @Override
    public Author updateAuthor(Long id, Author request) {
        Author oldAuthor = authorRepository.findById(id);
        if (oldAuthor == null) {
            return null;
        }
        oldAuthor.setName(request.getName());
        oldAuthor.setEmail(request.getEmail());
        return oldAuthor;
    }
    @Override
    public boolean deleteAuthor(Long id) {
        // Bước 1: tìm theo id
        Author author = authorRepository.findById(id);

        // Không tìm thấy
        if (author == null) {
            return false; // controller sẽ trả 404
        }

        // Bước 2: validate không cho xóa Admin (không phân biệt hoa thường)
        if (author.getName() != null && author.getName().equalsIgnoreCase("Admin")) {
            return false; // controller sẽ trả 400 (theo rule)
        }

        // Bước 3: xóa
        authorRepository.delete(id);
        return true;
    }


    }

