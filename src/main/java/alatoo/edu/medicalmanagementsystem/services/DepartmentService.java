package alatoo.edu.medicalmanagementsystem.services;

import alatoo.edu.medicalmanagementsystem.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAllDepartments();
    List<Department> searchDepartmentsByKeyword(String keyword);
    Optional<Department> findById(Long id);
    Department saveDepartment(Department department);
}
