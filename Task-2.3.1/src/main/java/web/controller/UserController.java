package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String show(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editPage";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/add")
    public String addPage(@ModelAttribute User user) {
        return "addPage";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
