package alatoo.edu.medicalmanagementsystem.entities;

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

    public Clinic() {
    }

    public Clinic(String name, User user, List<Department> departments) {
        this.name = name;
        this.user = user;
        this.departments = departments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
