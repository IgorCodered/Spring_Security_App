package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String admin(ModelMap map) {
        map.addAttribute("users", userService.findAll());
        return "admin";
    }

    @GetMapping("/admin/new")
    public String newUser(ModelMap map) {
        map.addAttribute("user", new User());
        map.addAttribute("availableRoles", roleService.findAll());
        return "/registration";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user,
                         @RequestParam(required = false) String role) {
        userService.saveUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/update")
    public String update(@RequestParam("id") Long id,
                         ModelMap model) {
        model.addAttribute("person", userService.findById(id).get());
        return "updateUser";
    }

    @PatchMapping("/admin/edit")
    public String postUpdate(@ModelAttribute("user") User user) {
//        if (result.hasErrors()) return "/admin";
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
