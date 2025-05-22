package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import alatoo.edu.medicalmanagementsystem.entities.Department;
import alatoo.edu.medicalmanagementsystem.entities.Doctor;
import alatoo.edu.medicalmanagementsystem.services.AppointmentService;
import alatoo.edu.medicalmanagementsystem.services.DepartmentService;
import alatoo.edu.medicalmanagementsystem.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DepartmentService departmentService;
    private final DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService,
                                 DepartmentService departmentService,
                                 DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.departmentService = departmentService;
        this.doctorService = doctorService;
    }

    @GetMapping("/book")
    public String showBookingFormByParam(@RequestParam Long departmentId, Model model) {
        Department department = departmentService.findById(departmentId).orElseThrow();
        List<Doctor> doctors = doctorService.findByDepartmentId(departmentId);

        model.addAttribute("department", department);
        model.addAttribute("doctors", doctors);
        model.addAttribute("appointment", new Appointment());
        return "appointments/book";
    }

    @PostMapping("/book/{departmentId}")
    public String submitBooking(@PathVariable Long departmentId,
                                @RequestParam Long doctorId,
                                @ModelAttribute Appointment appointment) {
        Department department = departmentService.findById(departmentId).orElseThrow();
        Doctor doctor = doctorService.findById(doctorId).orElseThrow();

        appointment.setDepartment(department);
        appointment.setDoctor(doctor);

        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments/thank-you";
    }

    @GetMapping("/thank-you")
    public String thankYouPage() {
        return "appointments/thank-you";
    }
}
