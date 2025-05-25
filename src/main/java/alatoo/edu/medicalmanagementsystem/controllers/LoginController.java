package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.User;
import alatoo.edu.medicalmanagementsystem.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String role,
                        Model model) {

        Optional<User> userOpt = userRepository.findByName(username);

        if (userOpt.isEmpty()) {
            model.addAttribute("error", "User not found");
            return "login";
        }

        User user = userOpt.get();

        // Простая проверка пароля (без хеширования для примера)
        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid password");
            return "login";
        }

        if (!user.getRole().equalsIgnoreCase(role)) {
            model.addAttribute("error", "Invalid role selected");
            return "login";
        }

        // Перенаправляем в зависимости от роли
        if (role.equalsIgnoreCase("CLIENT")) {
            return "redirect:/client/home";  // главная страница клиента
        } else if (role.equalsIgnoreCase("DOCTOR")) {
            return "redirect:/doctor/home";  // страница доктора (создадим позже)
        } else {
            model.addAttribute("error", "Unknown role");
            return "login";
        }
    }
}
