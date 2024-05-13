package com.arthur.biblioteca.controller;

import com.arthur.biblioteca.domain.Borrowing;
import com.arthur.biblioteca.dto.BorrowingDTO;
import com.arthur.biblioteca.service.BorrowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    BorrowingService borrowingService;
    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping
    @PutMapping
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody BorrowingDTO data) {
        Borrowing borrowing = borrowingService.saveBorrowing(data);
        return new ResponseEntity<>(borrowing, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable Long id) throws Exception {
        Borrowing borrowing = borrowingService.getBorrowingById(id);
        return new ResponseEntity<>(borrowing, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Borrowing>> getAllBorrowings() {
        List<Borrowing> borrowings = borrowingService.getAllBorrowings();
        return new ResponseEntity<>(borrowings, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBorrowing(@PathVariable Long id) throws Exception {
        borrowingService.deleteBorrowing(id);
        return new ResponseEntity<>("Empréstimo deletado.",HttpStatus.OK);
    }
}
