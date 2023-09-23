package org.example.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private int drugId;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "drug_description")
    private String drugDescription;

    @ManyToMany
    @JoinTable(name = "PatientDrug", joinColumns = @JoinColumn(name = "drug_id", referencedColumnName = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "patient_id"))
    private List<Patient> patients;
}