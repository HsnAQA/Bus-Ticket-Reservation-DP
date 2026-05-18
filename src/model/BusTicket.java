package model;

/**
 * MODEL - Concrete subclass of Ticket.
 * Kept for clarity. TicketFactory also creates plain Ticket objects directly.
 */
public class BusTicket extends Ticket {
    public BusTicket(String ticketId, String route,
                     String departureTime, double basePrice, String ticketClass) {
        super(ticketId, route, departureTime, basePrice, ticketClass);
    }
}
