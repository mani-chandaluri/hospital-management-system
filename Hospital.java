package com.hms;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Hospital {
    private String name;
    private String address;

    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Staff> staff = new ArrayList<>();
    private final List<Department> departments = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private final List<Billing> bills = new ArrayList<>();

    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Patient related
    public Patient registerPatient(String name, LocalDate dob, String gender, String phone, String address) {
        Patient p = new Patient(name, dob, gender, phone, address);
        patients.add(p);
        return p;
    }

    public Optional<Patient> findPatientById(int id) {
        return patients.stream().filter(p -> p.getId() == id).findFirst();
    }

    // Doctor related
    public Doctor hireDoctor(String name, String specialization, String phone, String address) {
        Doctor d = new Doctor(name, specialization, phone, address);
        doctors.add(d);
        return d;
    }

    public Optional<Doctor> findDoctorById(int id) {
        return doctors.stream().filter(d -> d.getId() == id).findFirst();
    }

    // Staff related
    public Staff hireStaff(String name, String role, String phone, String address) {
        Staff s = new Staff(name, role, phone, address);
        staff.add(s);
        return s;
    }

    // Department
    public Department createDepartment(String name) {
        Department dept = new Department(name);
        departments.add(dept);
        return dept;
    }

    // Appointment
    public Appointment scheduleAppointment(int patientId, int doctorId, LocalDateTime dateTime, String notes) {
        Patient p = findPatientById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        Doctor d = findDoctorById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        Appointment ap = new Appointment(p, d, dateTime, notes);
        appointments.add(ap);
        return ap;
    }

    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
        return appointments.stream().filter(a -> a.getDoctor().getId() == doctorId).collect(Collectors.toList());
    }

    // Billing
    public Billing createBill(int patientId) {
        Patient p = findPatientById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        Billing b = new Billing(p);
        bills.add(b);
        return b;
    }

    // Medical record
    public MedicalRecord addMedicalRecord(int patientId, LocalDate date, String notes, int doctorId) {
        Patient p = findPatientById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        Doctor d = findDoctorById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        MedicalRecord r = new MedicalRecord(date, notes, d);
        p.addMedicalRecord(r);
        return r;
    }

    // Simple listings
    public List<Patient> listPatients() { return new ArrayList<>(patients); }
    public List<Doctor> listDoctors() { return new ArrayList<>(doctors); }
    public List<Department> listDepartments() { return new ArrayList<>(departments);}
}