package builder;

import model.Booking;
import model.Passenger;
import model.Ticket;

/**
 * CREATIONAL - Builder Pattern.
 * Builds a Booking object step by step using a fluent chain.
 * .build() validates required fields before creating the object.
 */
public class BookingBuilder {
    private String    bookingId;
    private Passenger passenger;
    private Ticket    ticket;
    private int       seatNumber;
    private String    status = "CONFIRMED";

    public BookingBuilder setBookingId(String bookingId)     { this.bookingId  = bookingId;  return this; }
    public BookingBuilder setPassenger(Passenger passenger)  { this.passenger  = passenger;  return this; }
    public BookingBuilder setTicket(Ticket ticket)           { this.ticket     = ticket;     return this; }
    public BookingBuilder setSeatNumber(int seatNumber)      { this.seatNumber = seatNumber; return this; }
    public BookingBuilder setStatus(String status)           { this.status     = status;     return this; }

    public Booking build() {
        if (bookingId == null || passenger == null || ticket == null)
            throw new IllegalStateException("BookingId, Passenger, and Ticket are required.");
        return new Booking(bookingId, passenger, ticket, seatNumber, status);
    }
}
