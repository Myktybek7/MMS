package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.Clinic;
import alatoo.edu.medicalmanagementsystem.services.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("clinic", new Clinic());
        return "clinics/register"; // templates/clinics/register.html
    }

    @PostMapping("/register")
    public String registerClinic(@ModelAttribute("clinic") Clinic clinic) {
        clinicService.saveClinic(clinic);
        return "redirect:/departments";
    }
}
