package ru.kata.spring.boot_security.demo.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
@AllArgsConstructor
public class Init {

    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void init() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);

        User admin = new User("admin", "100",
                30, "igor@mail.ru", Set.of(roleAdmin));

        User user = new User("user", "100",
                30, "user@mail.ru", Set.of(roleUser));

        userService.saveUser(admin);
        userService.saveUser(user);
    }
}
