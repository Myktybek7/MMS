package alatoo.edu.medicalmanagementsystem.services;

import alatoo.edu.medicalmanagementsystem.entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getDoctorsByDepartmentId(Long departmentId);
    List<Doctor> findByDepartmentId(Long departmentId);
    Optional<Doctor> findById(Long id);
}
