package com.hms;



public class Doctor extends Person {
    private String specialization;

    public Doctor(String name, String specialization, String phone, String address) {
        super(name, phone, address);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String getDetails() {
        return "Doctor{id=" + id + ", name='" + name + "', specialization='" + specialization + "', phone='" + phone+"'}";
}
}