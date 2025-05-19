package alatoo.edu.medicalmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String position;
    private String description;
    private String imageUrl;



    @ManyToOne
    private Department department;
}
