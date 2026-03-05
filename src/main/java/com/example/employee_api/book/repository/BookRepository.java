package com.example.employee_api.book.repository;
import com.example.employee_api.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
