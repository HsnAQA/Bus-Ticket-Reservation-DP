package observer;

import model.Booking;
import model.Passenger;

/**
 * BEHAVIORAL - Observer Pattern (Interface).
 * Any notifier must implement this to be used by BookingFacade.
 */
public interface BookingObserver {
    void onBookingConfirmed(Passenger passenger, Booking booking);
}
