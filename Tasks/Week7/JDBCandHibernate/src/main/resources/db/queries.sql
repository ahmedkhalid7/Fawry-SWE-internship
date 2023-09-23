CREATE DATABASE HospitalDatabase;

CREATE TABLE `HospitalDatabase`.`Hospital` (
    hospital_id INT PRIMARY KEY,
    hospital_name VARCHAR(255),
    hospital_location VARCHAR(255),
    hospital_contact VARCHAR(255)
);

CREATE TABLE `HospitalDatabase`.`Doctor` (
    doctor_id INT PRIMARY KEY,
    doctor_name VARCHAR(255),
    doctor_specialty VARCHAR(255),
    doctor_contact VARCHAR(255),
    hospital_id INT,
    FOREIGN KEY (hospital_id) REFERENCES Hospital(hospital_id)
);

CREATE TABLE `HospitalDatabase`.`Patient` (
    patient_id INT PRIMARY KEY,
    patient_name VARCHAR(255),
    patient_gender VARCHAR(10),
    patient_date_of_birth DATE,
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE `HospitalDatabase`.`Drug` (
    drug_id INT PRIMARY KEY,
    drug_name VARCHAR(255),
    drug_description VARCHAR(255)
);

CREATE TABLE `HospitalDatabase`.`PatientDrug` (
    patient_id INT,
    drug_id INT,
    PRIMARY KEY (patient_id, drug_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (drug_id) REFERENCES Drug(drug_id)
);