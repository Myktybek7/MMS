package alatoo.edu.medicalmanagementsystem.services;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Optional<Appointment> findById(Long id);
    Appointment saveAppointment(Appointment appointment);
}
