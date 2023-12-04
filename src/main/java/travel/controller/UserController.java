package travel.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import travel.beans.User;
import travel.service.UserService;

public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.getUserbyId(id);
    }

    @GetMapping("/view")
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("Users", users);
        return "view-users";
    }
    
}
