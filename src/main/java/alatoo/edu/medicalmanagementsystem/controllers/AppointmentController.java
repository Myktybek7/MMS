package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import alatoo.edu.medicalmanagementsystem.entities.Department;
import alatoo.edu.medicalmanagementsystem.services.AppointmentService;
import alatoo.edu.medicalmanagementsystem.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DepartmentService departmentService;

    public AppointmentController(AppointmentService appointmentService, DepartmentService departmentService) {
        this.appointmentService = appointmentService;
        this.departmentService = departmentService;
    }

    @GetMapping("/book")
    public String showBookingFormByParam(@RequestParam Long departmentId, Model model) {
        Department department = departmentService.findById(departmentId).orElseThrow();
        model.addAttribute("department", department);
        model.addAttribute("appointment", new Appointment());
        return "appointments/book";
    }


    @PostMapping("/book/{departmentId}")
    public String submitBooking(@PathVariable Long departmentId, @ModelAttribute Appointment appointment) {
        Department department = departmentService.findById(departmentId).orElseThrow();
        appointment.setDepartment(department);
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments/thank-you";
    }

    @GetMapping("/thank-you")
    public String thankYouPage() {
        return "appointments/thank-you";
    }
}