package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String admin(ModelMap map) {
        map.addAttribute("users", userService.findAll());
        return "admin";
    }

    @GetMapping("/admin/new")
    public String newUser(ModelMap map) {
        User user = new User();
        map.addAttribute("user", user);
        return "/registration";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
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

    @PostMapping("/admin/create")
    public String postUpdate(@ModelAttribute("user") @Valid User user,
                             BindingResult result) {
        if (result.hasErrors()) return "/admin";
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
