package org.example;

import org.example.entities.Doctor;
import org.example.entities.Drug;
import org.example.entities.Hospital;
import org.example.entities.Patient;

import java.util.List;

public class JPAbasedProgram {
    public static void main(String[] args) {

        TestRepository testRepository = new TestRepository();
        for (int i = 1; i <= 4; i++) {
            Hospital hospital = testRepository.findHospital(i);

            System.out.println("===========================================================================================================================================");
            System.out.println("Hospital Details:");
            System.out.println("===========================================================================================================================================");

            System.out.println("Hospital Name: " + hospital.getHospitalName());
            System.out.println("Hospital Location: " + hospital.getHospitalLocation());
            System.out.println("Hospital Contact: " + hospital.getHospitalContact());
            System.out.println();

            // Retrieve doctors for the current hospital
            List<Doctor> doctors = hospital.getDoctors();

            for (Doctor doctor : doctors) {
                System.out.println("===========================================================================================================================================");
                System.out.println("Details of Doctors Working for " + hospital.getHospitalName() + ":");
                System.out.println("===========================================================================================================================================");

                System.out.println("Doctor Name: " + doctor.getDoctorName());
                System.out.println("Specialty: " + doctor.getDoctorSpeciality());
                System.out.println("Contact Info: " + doctor.getDoctorContact());
                System.out.println();

                // Retrieve patients assigned to the current doctor
                List<Patient> patients = doctor.getPatients();

                System.out.println("===========================================================================================================================================");
                System.out.println("Details of Patients Assigned for Dr. " + doctor.getDoctorName() + ":");
                System.out.println("===========================================================================================================================================");

                for (Patient patient : patients) {
                    System.out.println("Patient Name: " + patient.getPatientName());
                    System.out.println("Date Of Birth: " + patient.getPatientDateOfBirth());
                    System.out.println("Gender: " + patient.getPatientGender());
                    System.out.println();

                    // Retrieve drugs for the current patient
                    List<Drug> drugs = patient.getDrugs();

                    System.out.println("\tDetails of Drugs Written for Patient " + patient.getPatientName() + ":");

                    for (Drug drug : drugs) {
                        System.out.println("\t\tDrug Name: " + drug.getDrugName());
                        System.out.println("\t\tDrug Description: " + drug.getDrugDescription());
                        System.out.println();
                    }
                }
            }
        }
    }
}