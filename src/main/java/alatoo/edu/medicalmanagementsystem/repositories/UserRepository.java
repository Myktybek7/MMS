package alatoo.edu.medicalmanagementsystem.repositories;

import alatoo.edu.medicalmanagementsystem.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}
