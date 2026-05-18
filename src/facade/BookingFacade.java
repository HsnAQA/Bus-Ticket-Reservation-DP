package facade;

import builder.BookingBuilder;
import factory.TicketFactory;
import model.Booking;
import model.Passenger;
import model.Ticket;
import observer.PassengerNotifier;
import proxy.SeatAvailabilityProxy;
import strategy.PricingStrategy;

/**
 * STRUCTURAL - Facade Pattern.
 * Hides the full booking complexity behind one method: bookTicket().
 * Used by ITC (Imo Transport Company) to process all reservations.
 * Order of execution:
 *   1. Proxy    - validate and check seat availability
 *   2. Factory  - create the ticket
 *   3. Strategy - calculate the final price in NGN
 *   4. Builder  - assemble the Booking object
 *   5. Proxy    - reserve the seat in the database
 *   6. Observer - notify the passenger via SMS
 */
public class BookingFacade {
    private SeatAvailabilityProxy seatProxy;
    private PassengerNotifier     notifier;

    public BookingFacade() {
        this.seatProxy = new SeatAvailabilityProxy();
        this.notifier  = new PassengerNotifier();
    }

    public Booking bookTicket(String bookingId, Passenger passenger,
                              String ticketType, String route,
                              String departureTime, int seatNumber,
                              PricingStrategy pricingStrategy) {

        System.out.println("\n[Facade] Starting booking: " + bookingId);
        System.out.println("-".repeat(45));

        // Step 1 - Proxy: check availability
        System.out.println("[Step 1] Checking seat availability...");
        if (!seatProxy.isSeatAvailable(route, seatNumber)) {
            System.out.println("[Facade] Booking FAILED - seat not available.");
            return null;
        }

        // Step 2 - Factory: create ticket
        System.out.println("[Step 2] Creating ticket via Factory...");
        Ticket ticket = TicketFactory.createTicket(ticketType, bookingId + "-T", route, departureTime);
        System.out.println("  Ticket created: " + ticket.getType() + " | Base price: NGN " + ticket.getPrice());

        // Step 3 - Strategy: calculate price in NGN
        System.out.println("[Step 3] Applying pricing strategy...");
        double finalPrice = pricingStrategy.calculatePrice(ticket.getPrice());
        System.out.println("  Final price: NGN " + finalPrice);

        // Step 4 - Builder: assemble booking
        System.out.println("[Step 4] Building booking record...");
        Booking booking = new BookingBuilder()
            .setBookingId(bookingId)
            .setPassenger(passenger)
            .setTicket(ticket)
            .setSeatNumber(seatNumber)
            .setStatus("CONFIRMED")
            .build();

        // Step 5 - Proxy: reserve seat
        System.out.println("[Step 5] Reserving seat...");
        seatProxy.reserveSeat(route, seatNumber);

        // Step 6 - Observer: notify passenger
        System.out.println("[Step 6] Notifying passenger...");
        notifier.notifyPassenger(passenger, booking);

        return booking;
    }
}
