package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping(value = "/test")
    public String test() {


        return "test";
    }
    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model,@PathVariable("id")int id) {
        model.addAttribute("user",userService.getById(id));
        return "editUser";
    }
    @PostMapping(value = "/edit")
    public String update (@ModelAttribute("user") User user){
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String newUser (@ModelAttribute("user") User user){
        return "addUser";
    }

    @PostMapping(value = "/creat")
    public String creatUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping (value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(userService.getById(id));
        return "redirect:/";
    }

}