package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(ModelMap model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/creat")
    public String creatUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        return "redirect:/";
    }
}