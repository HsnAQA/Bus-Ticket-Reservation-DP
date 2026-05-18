package model;

/**
 * MODEL - Passenger data.
 * Holds the personal details of an ITC customer needed for booking and notification.
 */
public class Passenger {
    private String name;
    private String phone;
    private String nic;

    public Passenger(String name, String phone, String nic) {
        this.name  = name;
        this.phone = phone;
        this.nic   = nic;
    }

    public String getName()  { return name; }
    public String getPhone() { return phone; }
    public String getNic()   { return nic; }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | NIC: " + nic;
    }
}
