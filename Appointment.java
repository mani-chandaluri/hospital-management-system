
package com.hms;

import java.time.LocalDateTime;

public class Appointment implements Bookable {
    private final int appointmentId;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDateTime dateTime;
    private String notes;
    private boolean confirmed;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime dateTime, String notes) {
        this.appointmentId = Utils.nextId();
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.notes = notes;
        this.confirmed = false;
    }

    public int getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public boolean isConfirmed() { return confirmed; }

    @Override
    public void book() {
        this.confirmed = true;
        System.out.println("Appointment booked: " + this);
    }

    @Override
    public void cancel() {
        this.confirmed = false;
        System.out.println("Appointment cancelled: " + this);
    }

    @Override
    public String toString() {
        return "Appointment{id=" + appointmentId + ", patient=" + patient.getName() + ", doctor=" + doctor.getName() + ", dateTime=" + dateTime + ", confirmed=" + confirmed+"}";
}
}
