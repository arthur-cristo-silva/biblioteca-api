package com.arthur.biblioteca.controller;

import com.arthur.biblioteca.domain.Book;
import com.arthur.biblioteca.dto.BookDTO;
import com.arthur.biblioteca.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService service;
    public BookController(BookService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookDTO data) {
        Book book = service.save(data);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> get(@PathVariable Long id) throws Exception {
        Book book = service.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = service.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody BookDTO data) {
        Book book = service.save(data);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>("Livro deletado.", HttpStatus.OK);
    }
}
