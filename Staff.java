
package com.hms;

public class Staff extends Person {
    private String role;

    public Staff(String name, String role, String phone, String address) {
        super(name, phone, address);
        this.role = role;
    }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String getDetails() {
        return "Staff{id=" + id + ", name='" + name + "', role='" + role + "', phone='" + phone+"'}";
}
}
