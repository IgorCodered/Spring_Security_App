package ru.kata.spring.boot_security.demo.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String name;

    @OneToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return getName();
    }
}
