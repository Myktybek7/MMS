package alatoo.edu.medicalmanagementsystem.config;

import alatoo.edu.medicalmanagementsystem.entities.Clinic;
import alatoo.edu.medicalmanagementsystem.entities.Department;
import alatoo.edu.medicalmanagementsystem.services.ClinicService;
import alatoo.edu.medicalmanagementsystem.services.DepartmentService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataInitializer {

    private final DepartmentService departmentService;
    private final ClinicService clinicService;

    public DataInitializer(DepartmentService departmentService, ClinicService clinicService) {
        this.departmentService = departmentService;
        this.clinicService = clinicService;
    }

    @PostConstruct
    public void init() {

        Clinic clinic = new Clinic();
        clinic.setName("Central Medical Clinic");
        clinic.setAddress("10 Lenin St, Bishkek");
        clinicService.saveClinic(clinic);

        departmentService.saveDepartment(new Department(
                "Ophthalmology",
                "Eye diseases department",
                "/images/ophthalmology.jpg",
                "eye, vision, ophthalmology",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Dentistry",
                "Dental services department",
                "/images/dentistry.jpeg",
                "teeth, dentist, dental",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Dermatology",
                "Skin diseases department",
                "/images/dermatology.jpg",
                "skin, dermatology",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Cardiology",
                "Cardiovascular diseases department",
                "/images/cardiology.jpg",
                "heart, cardiovascular, cardiology",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Neurology",
                "Nervous system diseases department",
                "/images/neurology.jpeg",
                "brain, nervous system, neurology",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Pediatrics",
                "Children's department",
                "/images/pediatrics.png",
                "children, pediatrics, kids",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Orthopedics",
                "Musculoskeletal system department",
                "/images/orthopedics.jpg",
                "bones, joints, orthopedics",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Gynecology",
                "Women's health department",
                "/images/gynecology.jpg",
                "women, gynecology, pregnancy",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "ENT",
                "Ear, Nose and Throat department",
                "/images/ent.jpeg",
                "ear, nose, throat, ent",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Gastroenterology",
                "Digestive system diseases department",
                "/images/gastroenterology.jpeg",
                "stomach, digestion, gastroenterology",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Pulmonology",
                "Respiratory system diseases department",
                "/images/pulmonology.jpg",
                "lungs, respiratory, pulmonology",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Psychiatry",
                "Mental health department",
                "/images/psychiatry.jpeg",
                "mental health, psychiatry",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Endocrinology",
                "Hormonal diseases department",
                "/images/endocrinology.jpg",
                "hormones, endocrine system, endocrinology",
                clinic,
                Collections.emptyList()
        ));

        departmentService.saveDepartment(new Department(
                "Urology",
                "Urinary system diseases department",
                "/images/urology.jpeg",
                "urinary system, urology",
                clinic,
                Collections.emptyList()
        ));


        System.out.println(">>> Clinic and Department SAVED <<<");
    }


}
