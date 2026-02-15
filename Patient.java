
package com.hms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private LocalDate dob;
    private String gender;
    private final List<MedicalRecord> medicalRecords = new ArrayList<>();

    public Patient(String name, LocalDate dob, String gender, String phone, String address) {
        super(name, phone, address);
        this.dob = dob;
        this.gender = gender;
    }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public List<MedicalRecord> getMedicalRecords() {
        return new ArrayList<>(medicalRecords);
    }

    @Override
    public String getDetails() {
        return "Patient{id=" + id + ", name='" + name + "', dob=" + dob + ", gender='" + gender + "', phone='" + phone+"'}";
}
}