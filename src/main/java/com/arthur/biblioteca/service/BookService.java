package com.arthur.biblioteca.service;

import com.arthur.biblioteca.domain.Book;
import com.arthur.biblioteca.dto.BookDTO;
import com.arthur.biblioteca.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    BookRepository repository;
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    public Book save(BookDTO data) {
        Book book = new Book(data);
        repository.save(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Livro não encontrado."));
    }

    public void delete(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("Livro não encontrado.");
        }
    }
}
