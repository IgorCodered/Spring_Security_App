package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    Optional<User> findById(Long id);
    void delete(Long id);
    void saveUser(User user);
    void updateUser(User user);
}
