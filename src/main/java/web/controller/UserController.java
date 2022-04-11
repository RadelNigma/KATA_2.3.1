package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.dao.UserDAO;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model,@PathVariable("id")int id) {
//        User user = userService.getById(id);
        model.addAttribute("user",userService.getById(id));
        return "editUser";
    }
    @PostMapping(value = "/edit")
      public String update (@ModelAttribute("user") User user){
        userService.edit(user);
        return "redirect:/";
     }


}
