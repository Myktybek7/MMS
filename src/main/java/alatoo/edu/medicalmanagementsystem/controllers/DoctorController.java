package alatoo.edu.medicalmanagementsystem.controllers;

import alatoo.edu.medicalmanagementsystem.entities.Department;
import alatoo.edu.medicalmanagementsystem.entities.Doctor;
import alatoo.edu.medicalmanagementsystem.services.DepartmentService;
import alatoo.edu.medicalmanagementsystem.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    public DoctorController(DoctorService doctorService, DepartmentService departmentService) {
        this.doctorService = doctorService;
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors/list";
    }

    @GetMapping("/view/{id}")
    public String doctorDetails(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            System.out.println("Doctor with id " + id + " not found.");
            return "redirect:/doctors/list";
        }
        System.out.println("Doctor found: " + doctor.getFullName());
        model.addAttribute("doctor", doctor);
        return "doctors/details";
    }

    @GetMapping("/department/{departmentId}")
    public String listDoctorsByDepartment(@PathVariable Long departmentId, Model model) {
        List<Doctor> doctors = doctorService.getDoctorsByDepartmentId(departmentId);
        model.addAttribute("doctors", doctors);
        return "doctors/listByDepartment";  // страница со списком врачей данного отделения
    }

}

