package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import alatoo.edu.medicalmanagementsystem.entities.Doctor;
import alatoo.edu.medicalmanagementsystem.repositories.AppointmentRepository;
import alatoo.edu.medicalmanagementsystem.repositories.DoctorRepository;
import alatoo.edu.medicalmanagementsystem.services.AppointmentService;
import alatoo.edu.medicalmanagementsystem.services.DepartmentService;
import alatoo.edu.medicalmanagementsystem.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;
    private final DepartmentService departmentService;
    private final AppointmentService appointmentService;

    public DoctorController(DoctorService doctorService,
                            DepartmentService departmentService,
                            AppointmentRepository appointmentRepository,
                            DoctorRepository doctorRepository,
                            AppointmentService appointmentService) {
        this.doctorService = doctorService;
        this.departmentService = departmentService;
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/list")
    public String listDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctors/list";
    }

    @GetMapping("/home")
    public String doctorHome() {
        return "doctors/home";
    }

    @GetMapping("/add")
    public String showAddDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "doctors/add";
    }


    @PostMapping("/add")
    public String saveDoctor(@ModelAttribute Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/list";
    }

    @GetMapping("/appointments")
    public String listDoctorAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments(); // или через репозиторий
        model.addAttribute("appointments", appointments);
        return "doctors/appointments";
    }


    @GetMapping("/view/{id}")
    public String doctorDetails(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            model.addAttribute("error", "Doctor not found");
            return "redirect:/doctors/list";
        }
        model.addAttribute("doctor", doctor);
        return "doctors/details";
    }

    @GetMapping("/department/{departmentId}")
    public String listDoctorsByDepartment(@PathVariable Long departmentId, Model model) {
        List<Doctor> doctors = doctorService.getDoctorsByDepartmentId(departmentId);
        model.addAttribute("doctors", doctors);
        model.addAttribute("department", departmentService.findById(departmentId));
        return "doctors/listByDepartment";
    }
}
