package alatoo.edu.medicalmanagementsystem.services;

import alatoo.edu.medicalmanagementsystem.entities.Clinic;

import java.util.List;
import java.util.Optional;

public interface ClinicService {
    List<Clinic> getAllClinics();
    Optional<Clinic> findById(Long id);
    Clinic saveClinic(Clinic clinic);
}

