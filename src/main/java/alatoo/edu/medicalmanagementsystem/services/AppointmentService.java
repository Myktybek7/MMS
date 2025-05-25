package alatoo.edu.medicalmanagementsystem.services;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;

import java.util.Optional;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    Optional<Appointment> findById(Long id);
}
