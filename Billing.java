
package com.hms;

import java.util.ArrayList;
import java.util.List;

public class Billing {
    private final int billId;
    private final Patient patient;
    private final List<String> items = new ArrayList<>();
    private double total = 0.0;

    public Billing(Patient patient) {
        this.billId = Utils.nextId();
        this.patient = patient;
    }

    public int getBillId() { return billId; }
    public Patient getPatient() { return patient; }

    // Simple add item (single unit)
    public void addItem(String itemDesc, double price) {
        addItem(itemDesc, price, 1);
    }

    // Overloaded: add item with quantity -> demonstrates method overloading (polymorphism)
    public void addItem(String itemDesc, double price, int quantity) {
        if (quantity <= 0) quantity = 1;
        items.add(itemDesc + " x" + quantity + " - " + (price * quantity));
        total += price * quantity;
    }

    public double getTotal() { return total; }
    public List<String> getItems() { return new ArrayList<>(items); }

    @Override
    public String toString() {
        return "Billing{billId=" + billId + ", patient=" + patient.getName() + ", total=" + total+"}";
}
}
