package alatoo.edu.medicalmanagementsystem.repositories;

import alatoo.edu.medicalmanagementsystem.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
