package model;

/**
 * MODEL - Final booking record for Imo Transport Company (ITC).
 * Assembled by BookingBuilder and displayed by BookingView.
 */
public class Booking {
    private String    bookingId;
    private Passenger passenger;
    private Ticket    ticket;
    private int       seatNumber;
    private String    status;

    public Booking(String bookingId, Passenger passenger,
                   Ticket ticket, int seatNumber, String status) {
        this.bookingId  = bookingId;
        this.passenger  = passenger;
        this.ticket     = ticket;
        this.seatNumber = seatNumber;
        this.status     = status;
    }

    public String    getBookingId()  { return bookingId; }
    public Passenger getPassenger()  { return passenger; }
    public Ticket    getTicket()     { return ticket; }
    public int       getSeatNumber() { return seatNumber; }
    public String    getStatus()     { return status; }

    @Override
    public String toString() {
        return "Booking ID : " + bookingId
             + "\n" + passenger
             + "\nTicket     : " + ticket
             + "\nSeat No.   : " + seatNumber
             + "\nStatus     : " + status;
    }
}
