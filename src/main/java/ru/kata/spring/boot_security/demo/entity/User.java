package ru.kata.spring.boot_security.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    @NotEmpty(message = "Username должен быть минимум 4 символа")
    @Min(value = 4)
    private String username;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "surname")
    @NotEmpty
    private String surname;

    @Column(name = "age")
    @NotEmpty
    @Min(value = 0, message = "Ваш возраст не должен быть отрицательным")
    private byte age;

    @Email
    @NotEmpty(message = "Заполните строку email")
    @Column(name = "email")
    private String email;


    @ManyToOne
    private Role roles;

}
