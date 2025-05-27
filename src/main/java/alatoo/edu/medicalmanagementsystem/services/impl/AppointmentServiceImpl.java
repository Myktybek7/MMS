package alatoo.edu.medicalmanagementsystem.services.impl;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import alatoo.edu.medicalmanagementsystem.repositories.AppointmentRepository;
import alatoo.edu.medicalmanagementsystem.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }
}
