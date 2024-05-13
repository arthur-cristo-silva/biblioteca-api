package com.arthur.biblioteca.repository;

import com.arthur.biblioteca.domain.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    Optional<Borrowing> findBorrowingById(Long id);
}
