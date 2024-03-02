package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    List<Role> findAll();
    Role findRoleByName(String roleName);
    void setRole(User user, String role);
}
