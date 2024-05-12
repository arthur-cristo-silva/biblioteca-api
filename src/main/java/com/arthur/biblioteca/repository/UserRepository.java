package com.arthur.biblioteca.repository;

import com.arthur.biblioteca.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByDocument(String document);
}
