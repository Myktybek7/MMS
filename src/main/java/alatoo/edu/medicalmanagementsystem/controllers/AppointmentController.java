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
import java.util.NoSuchElementException;

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
        Department department = departmentService.findById(departmentId)
                .orElseThrow(() -> new NoSuchElementException("Department not found with id: " + departmentId));
        List<Doctor> doctors = doctorService.findByDepartmentId(departmentId);

        model.addAttribute("department", department);
        model.addAttribute("doctors", doctors);
        model.addAttribute("appointment", new Appointment());

        return "appointments/book";
    }


    @PostMapping("/book/{departmentId}")
    public String submitBooking(@PathVariable Long departmentId,
                                @ModelAttribute Appointment appointment) {
        Department department = departmentService.findById(departmentId)
                .orElseThrow(() -> new NoSuchElementException("Department not found with id: " + departmentId));

        Long doctorId = appointment.getDoctor().getId();
        Doctor doctor = doctorService.findById(doctorId)
                .orElseThrow(() -> new NoSuchElementException("Doctor not found with id: " + doctorId));

        appointment.setDepartment(department);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentService.saveAppointment(appointment);

        return "redirect:/appointments/thank-you?appointmentId=" + savedAppointment.getId();
    }

    @GetMapping("/thank-you")
    public String thankYouPage(@RequestParam Long appointmentId, Model model) {
        Appointment appointment = appointmentService.findById(appointmentId)
                .orElseThrow(() -> new NoSuchElementException("Appointment not found with id: " + appointmentId));

        model.addAttribute("appointment", appointment);
        return "appointments/thank-you";
    }
}
