package com.arthur.biblioteca.service;

import com.arthur.biblioteca.domain.Book;
import com.arthur.biblioteca.domain.Borrowing;
import com.arthur.biblioteca.dto.BorrowingDTO;
import com.arthur.biblioteca.repository.BorrowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingService {

    BorrowingRepository borrowingRepository;
    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    public Borrowing saveBorrowing(BorrowingDTO data) {
        Borrowing borrowing = new Borrowing(data);
        borrowingRepository.save(borrowing);
        return borrowing;
    }

    public Borrowing getBorrowingById(Long id) throws Exception {
        return borrowingRepository.findBorrowingById(id).
                orElseThrow(() -> new Exception("Empréstimo não encontrado."));
    }

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public void deleteBorrowing(Long id) throws Exception {
        if (borrowingRepository.existsById(id)) {
            borrowingRepository.deleteById(id);
        } else {
            throw new Exception("Empréstimo não encontrado.");
        }
    }
}
