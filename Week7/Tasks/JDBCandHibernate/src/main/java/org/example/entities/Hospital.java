package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private int hospitalIDd;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "hospital_location")
    private String hospitalLocation;

    @Column(name = "hospital_contact")
    private String hospitalContact;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;
}


