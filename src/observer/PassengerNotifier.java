package observer;

import model.Booking;
import model.Passenger;

/**
 * BEHAVIORAL - Observer Pattern (Concrete Observer).
 * Called by BookingFacade after a booking is confirmed.
 * Sends an SMS notification to the passenger.
 */
public class PassengerNotifier implements BookingObserver {

    @Override
    public void onBookingConfirmed(Passenger passenger, Booking booking) {
        System.out.println("  [SMS] Sent to " + passenger.getPhone()
            + " - Booking " + booking.getBookingId() + " is CONFIRMED.");
    }

    public void notifyPassenger(Passenger passenger, Booking booking) {
        onBookingConfirmed(passenger, booking);
    }
}
