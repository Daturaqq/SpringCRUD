package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
        // Юзеры для теста
        service.add(new User("One", "Two","OneTwo@mail.com"));
        service.add(new User("Some", "One","Someone@mail.com"));
        service.add(new User("123", "321","123321@mail.com"));
        service.add(new User("Elon", "Tusk","ElonTusk@mail.com"));
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<User> userList = service.getAllUsers();
        model.addAttribute("users", userList);
        return "mainPage";
    }

    @GetMapping("/show/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "showUser";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        service.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editUser", service.getUser(id));
        return "editUser";
    }

    @PatchMapping("/saveEdit/{id}")
    public String updateUser(@ModelAttribute("editUser") User editUser, @PathVariable("id") Long id) {
        service.edit(editUser, id);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
