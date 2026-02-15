
package com.hms;

import java.time.LocalDate;

public class MedicalRecord {
    private final int recordId;
    private final LocalDate date;
    private String notes;
    private Doctor doctor;

    public MedicalRecord(LocalDate date, String notes, Doctor doctor) {
        this.recordId = Utils.nextId();
        this.date = date;
        this.notes = notes;
        this.doctor = doctor;
    }

    public int getRecordId() { return recordId; }
    public LocalDate getDate() { return date; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    @Override
    public String toString() {
        return "MedicalRecord{recordId=" + recordId + ", date=" + date + ", doctor=" + (doctor != null ? doctor.getName() : "-")+"}";
}
}
