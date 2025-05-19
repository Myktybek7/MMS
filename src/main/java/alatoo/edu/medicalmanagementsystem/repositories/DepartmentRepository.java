package alatoo.edu.medicalmanagementsystem.repositories;

import alatoo.edu.medicalmanagementsystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByKeywordsContainingIgnoreCase(String keyword);
}
