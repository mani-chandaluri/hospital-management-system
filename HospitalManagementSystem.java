package com.hms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("CityCare Hospital", "123 Main St");

        Scanner sc = new Scanner(System.in);
        int choice;
        Doctor drSmith = hospital.hireDoctor("Dr. John Smith", "Cardiology", "999-000-111", "Doctor Residence");
        Doctor drKhan = hospital.hireDoctor("Dr. Aisha Khan", "Pediatrics", "999-000-222", "Doctor Residence");
        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Hire Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Add Medical Record");
            System.out.println("5. Create Bill");
            System.out.println("6. View Patients");
            System.out.println("7. View Doctors");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:     // Register Patient
                    System.out.print("Enter patient name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    LocalDate dob = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    Patient newPatient = hospital.registerPatient(pname, dob, gender, phone, address);
                    System.out.println("Patient registered with ID: " + newPatient.getId());
                    break;

                case 2:     // Hire Doctor
                    System.out.print("Enter doctor name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String dphone = sc.nextLine();
                    System.out.print("Enter address: ");
                    String daddress = sc.nextLine();

                    Doctor newDoctor = hospital.hireDoctor(dname, specialization, dphone, daddress);
                    System.out.println("Doctor hired with ID: " + newDoctor.getId());
                    break;

                case 3:     // Schedule Appointment
                    System.out.print("Enter patient ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter date and time (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime dt = LocalDateTime.parse(sc.nextLine());
                    System.out.print("Enter notes: ");
                    String notes = sc.nextLine();

                    Appointment appointment = hospital.scheduleAppointment(pid, did, dt, notes);
                    appointment.book();     // confirms appointment
                    break;

                case 4:     // Add Medical Record
                    System.out.print("Enter patient ID: ");
                    int mpid = sc.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int mdid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter notes: ");
                    String recnotes = sc.nextLine();

                    MedicalRecord rec = hospital.addMedicalRecord(mpid, LocalDate.now(), recnotes, mdid);
                    System.out.println("Medical Record Added: " + rec);
                    break;

                case 5:      // Create Bill
                    System.out.print("Enter patient ID: ");
                    int bpid = sc.nextInt();
                    sc.nextLine();

                    Billing bill = hospital.createBill(bpid);
                    System.out.println("Bill Created. Bill ID: " + bill.getBillId());

                    char addMore;
                    do {
                        System.out.print("Enter Item Description: ");
                        String item = sc.nextLine();
                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();

                        bill.addItem(item, price, qty);

                        System.out.print("Add another item? (y/n): ");
                        addMore = sc.next().charAt(0);
                        sc.nextLine();

                    } while (addMore == 'y' || addMore == 'Y');

                    System.out.println("\n--- Bill Summary ---");
                    System.out.println("Patient: " + bill.getPatient().getName());
                    bill.getItems().forEach(System.out::println);
                    System.out.println("Total Amount: ₹" + bill.getTotal());
                    break;

                case 6:
                    System.out.println("\n--- Patients List ---");
                    List<Patient> patients = hospital.listPatients();
                    patients.forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("\n--- Doctors List ---");
                    List<Doctor> doctors = hospital.listDoctors();
                    doctors.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Exiting System... Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);

        sc.close();
}
}