package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.User;
import alatoo.edu.medicalmanagementsystem.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // имя thymeleaf шаблона регистрации
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user) {
        // Тут можно добавить хеширование пароля через BCrypt, если хочешь
        userRepository.save(user);
        return "redirect:/login"; // После регистрации — перенаправить на логин
    }
}
