package com.arthur.biblioteca.service;

import com.arthur.biblioteca.domain.User;
import com.arthur.biblioteca.dto.UserDTO;
import com.arthur.biblioteca.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado."));
    }

    public User saveUser(UserDTO data) {
        User user = new User(data);
        repository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("Usuario não encontrado.");
        }
    }
}
