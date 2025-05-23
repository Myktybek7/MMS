package alatoo.edu.medicalmanagementsystem.repositories;

import alatoo.edu.medicalmanagementsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
