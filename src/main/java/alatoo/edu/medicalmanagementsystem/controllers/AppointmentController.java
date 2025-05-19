package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import alatoo.edu.medicalmanagementsystem.services.AppointmentService;
import alatoo.edu.medicalmanagementsystem.services.DoctorService;
import alatoo.edu.medicalmanagementsystem.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;
    private final DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService, UserService userService, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
        this.doctorService = doctorService;
    }

    @GetMapping("/new")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "appointments/form"; // templates/appointments/form.html
    }

    @PostMapping("/save")
    public String saveAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments/list";
    }

    @GetMapping("/list")
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments/list";
    }
}
