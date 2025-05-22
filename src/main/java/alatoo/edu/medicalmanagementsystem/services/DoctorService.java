package alatoo.edu.medicalmanagementsystem.services;

import alatoo.edu.medicalmanagementsystem.entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);

}