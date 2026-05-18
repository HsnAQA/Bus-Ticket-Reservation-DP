package model;

/**
 * MODEL - Core data class.
 * Represents a bus ticket for Imo Transport Company (ITC).
 * Created by TicketFactory, wrapped by TicketDecorator, stored inside Booking.
 */
public class Ticket {
    protected String ticketId;
    protected String route;
    protected String departureTime;
    protected double basePrice;
    private   String ticketClass; // STANDARD, VIP, EXPRESS

    public Ticket(String ticketId, String route, String departureTime,
                  double basePrice, String ticketClass) {
        this.ticketId      = ticketId;
        this.route         = route;
        this.departureTime = departureTime;
        this.basePrice     = basePrice;
        this.ticketClass   = ticketClass;
    }

    public String getType()          { return "BUS-" + ticketClass; }
    public double getPrice()         { return basePrice; }
    public String getRoute()         { return route; }
    public String getDepartureTime() { return departureTime; }
    public String getTicketId()      { return ticketId; }

    @Override
    public String toString() {
        return "[" + getType() + "]"
             + " Route: "      + route
             + " | Departs: "  + departureTime
             + " | Price: NGN " + getPrice();
    }
}
