
package com.hms;

public abstract class Person {
    protected final int id;
    protected String name;
    protected String phone;
    protected String address;

    public Person(String name, String phone, String address) {
        this.id = Utils.nextId();
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    /**
     * Abstract method to be implemented by subclasses.
     * This demonstrates abstraction + enables polymorphic behavior.
     */
    public abstract String getDetails();

    @Override
    public String toString() {
        return this.getDetails();
}
}