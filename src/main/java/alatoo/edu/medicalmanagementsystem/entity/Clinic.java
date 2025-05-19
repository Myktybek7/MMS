package alatoo.edu.medicalmanagementsystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<Department> departments;
}
