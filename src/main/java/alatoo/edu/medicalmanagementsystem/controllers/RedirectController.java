package alatoo.edu.medicalmanagementsystem.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirect")
    public String redirectAfterLogin(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream()
                .findFirst().get().getAuthority();

        if (role.equals("ROLE_CLIENT")) {
            return "redirect:client/home";
        } else if (role.equals("ROLE_DOCTOR")) {
            return "redirect:doctor/home";
        }

        return "redirect:/login";
    }
}

