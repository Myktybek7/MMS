package alatoo.edu.medicalmanagementsystem.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private String clientName;
    private String clientContact;

    @ManyToOne
    private Department department;

    public Appointment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientContact() { return clientContact; }
    public void setClientContact(String clientContact) { this.clientContact = clientContact; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
