package alatoo.edu.medicalmanagementsystem.repositories;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
