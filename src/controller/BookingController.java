package controller;

import facade.BookingFacade;
import model.Booking;
import model.Passenger;
import strategy.PricingStrategy;
import view.BookingView;

/**
 * MVC - Controller.
 * Receives requests, delegates all logic to BookingFacade,
 * then tells BookingView to display the result or an error.
 */
public class BookingController {
    private BookingFacade facade;
    private BookingView   view;

    public BookingController(BookingView view) {
        this.facade = new BookingFacade();
        this.view   = view;
    }

    public void processBooking(String bookingId, Passenger passenger,
                               String ticketType, String route,
                               String departureTime, int seatNumber,
                               PricingStrategy pricingStrategy) {

        view.showMessage("New booking request for: " + passenger.getName());

        Booking booking = facade.bookTicket(
            bookingId, passenger, ticketType,
            route, departureTime, seatNumber, pricingStrategy
        );

        if (booking != null) {
            view.showBookingDetails(booking);
        } else {
            view.showError("Booking failed. Please choose a different seat.");
        }
    }
}
