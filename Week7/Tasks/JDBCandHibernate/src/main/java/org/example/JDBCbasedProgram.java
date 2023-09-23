package org.example;

import java.sql.*;

public class JDBCbasedProgram {
    public static void main(String[] args) {
        // Connection and statement objects
        Statement hospitalStatement = null;
        PreparedStatement doctorStatement = null;
        PreparedStatement patientStatement = null;
        PreparedStatement drugStatement = null;

        ResultSet hospitalResultSet = null;
        ResultSet doctorResultSet = null;
        ResultSet patientResultSet = null;
        ResultSet drugResultSet = null;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalDatabase", "root", "ahmedk4635172")){
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Query to retrieve hospital details
            String hospitalQuery = "SELECT hospital_name, hospital_location, hospital_contact FROM Hospital";

            // Create a statement object
            hospitalStatement = connection.createStatement();
            hospitalResultSet = hospitalStatement.executeQuery(hospitalQuery);

            // Process hospital details
            while (hospitalResultSet.next()) {
                String hospitalName = hospitalResultSet.getString("hospital_name");
                String hospitalLocation = hospitalResultSet.getString("hospital_location");
                String hospitalContact = hospitalResultSet.getString("hospital_contact");

                System.out.println("===============================================================================================================================================");
                System.out.println("Hospital Details:");
                System.out.println("===============================================================================================================================================");

                System.out.println("Hospital Name: " + hospitalName);
                System.out.println("Hospital Location: " + hospitalLocation);
                System.out.println("Hospital Contact: " + hospitalContact);
                System.out.println();

                // Query to retrieve doctor details for the current hospital
                String doctorQuery = "SELECT doctor_name, doctor_specialty, doctor_contact " +
                        "FROM Doctor " +
                        "WHERE hospital_id IN (SELECT hospital_id FROM Hospital WHERE hospital_name = ?)";

                doctorStatement = connection.prepareStatement(doctorQuery);
                doctorStatement.setString(1, hospitalName);
                doctorResultSet = doctorStatement.executeQuery();

                // Process doctor details for the current hospital
                while (doctorResultSet.next()) {
                    String doctorName = doctorResultSet.getString("doctor_name");
                    String doctorSpecialty = doctorResultSet.getString("doctor_specialty");
                    String doctorContact = doctorResultSet.getString("doctor_contact");

                    System.out.println("===============================================================================================================================================");
                    System.out.println("Details of Doctors Working for " + hospitalName +":");
                    System.out.println("===============================================================================================================================================");

                    System.out.println("Doctor Name: " + doctorName);
                    System.out.println("Specialty: " + doctorSpecialty);
                    System.out.println("Contact Info: " + doctorContact);
                    System.out.println();

                    // Query to retrieve patient details for the current doctor
                    String patientQuery = "SELECT patient_name, patient_date_of_birth, patient_gender " +
                            "FROM Patient " +
                            "WHERE doctor_id IN (SELECT doctor_id FROM Doctor WHERE doctor_name = ?)";

                    patientStatement = connection.prepareStatement(patientQuery);
                    patientStatement.setString(1, doctorName);
                    patientResultSet = patientStatement.executeQuery();

                    System.out.println("===============================================================================================================================================");
                    System.out.println("Details of Patients Assigned for Dr. " + doctorName + ":");
                    System.out.println("===============================================================================================================================================");

                    // Process patient details for the current doctor
                    while (patientResultSet.next()) {
                        String patientName = patientResultSet.getString("patient_name");
                        Date patientDateOfBirth = patientResultSet.getDate("patient_date_of_birth");
                        String patientGender = patientResultSet.getString("patient_gender");

                        System.out.println("Patient Name: " + patientName);
                        System.out.println("Date Of Birth: " + patientDateOfBirth);
                        System.out.println("Gender: " + patientGender);
                        System.out.println();

                        // Query to retrieve drug details for the current patient
                        String drugQuery = "SELECT drug_name, drug_description " +
                                "FROM Drug " +
                                "WHERE drug_id IN (SELECT drug_id FROM PatientDrug WHERE patient_id IN (SELECT patient_id FROM Patient WHERE patient_name = ?))";

                        drugStatement = connection.prepareStatement(drugQuery);
                        drugStatement.setString(1, patientName);
                        drugResultSet = drugStatement.executeQuery();

                        System.out.println("\tDetails of Drugs Written for Patient " + patientName + ":");

                        // Process drug details for the current patient
                        while (drugResultSet.next()) {
                            String drugName = drugResultSet.getString("drug_name");
                            String drugDescription = drugResultSet.getString("drug_description");

                            System.out.println("\t\tDrug Name: " + drugName);
                            System.out.println("\t\tDrug Description: " + drugDescription);
                            System.out.println();
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (hospitalStatement != null) hospitalStatement.close();
                if (doctorStatement != null) doctorStatement.close();
                if (patientStatement != null) patientStatement.close();
                if (drugStatement != null) drugStatement.close();

                if (hospitalResultSet != null) hospitalResultSet.close();
                if (doctorResultSet != null) doctorResultSet.close();
                if (patientResultSet != null) patientResultSet.close();
                if (drugResultSet != null) drugResultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}