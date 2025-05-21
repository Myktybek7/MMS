package alatoo.edu.medicalmanagementsystem.services.impl;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import alatoo.edu.medicalmanagementsystem.repositories.AppointmentRepository;
import alatoo.edu.medicalmanagementsystem.services.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
