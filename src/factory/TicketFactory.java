package factory;

import model.Ticket;

/**
 * CREATIONAL - Factory Method Pattern.
 * Creates ITC bus tickets by type (STANDARD / VIP / EXPRESS).
 * Prices are in Nigerian Naira (NGN) based on ITC fare structure.
 * The caller never needs to know prices or constructor details.
 */
public class TicketFactory {
    public static final String STANDARD = "STANDARD";
    public static final String VIP      = "VIP";
    public static final String EXPRESS  = "EXPRESS";

    public static Ticket createTicket(String type, String ticketId,
                                      String route, String departureTime) {
        switch (type.toUpperCase()) {
            case STANDARD: return new Ticket(ticketId, route, departureTime, 3500.0,  STANDARD);
            case VIP:      return new Ticket(ticketId, route, departureTime, 7000.0,  VIP);
            case EXPRESS:  return new Ticket(ticketId, route, departureTime, 5000.0,  EXPRESS);
            default: throw new IllegalArgumentException("Unknown ticket type: " + type);
        }
    }
}
