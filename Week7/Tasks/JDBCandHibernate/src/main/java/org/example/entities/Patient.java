package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Entity
@Table
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_gender")
    private String patientGender;

    @Column(name = "patient_date_of_birth")
    private Date patientDateOfBirth;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    Doctor doctor;

    @ManyToMany
    @JoinTable(name = "PatientDrug", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id", referencedColumnName = "drug_id"))
    private List<Drug> drugs;
}