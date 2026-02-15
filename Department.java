
package com.hms;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private final List<Doctor> doctors = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void addDoctor(Doctor d) { doctors.add(d); }
    public List<Doctor> getDoctors() { return new ArrayList<>(doctors); }

    @Override
    public String toString() {
        return "Department{name='" + name + "', doctorsCount=" + doctors.size()+"}";
}
}