package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.Doctor;
import alatoo.edu.medicalmanagementsystem.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/list")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctors/form";
    }

    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }
}
