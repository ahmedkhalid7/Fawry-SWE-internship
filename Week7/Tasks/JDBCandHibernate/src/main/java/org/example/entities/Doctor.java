package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "doctor_speciality")
    private String doctorSpeciality;

    @Column(name = "doctor_contact")
    private String doctorContact;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
}