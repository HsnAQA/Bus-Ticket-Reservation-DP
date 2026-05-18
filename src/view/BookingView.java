package view;

import model.Booking;

/**
 * MVC - View.
 * Responsible only for displaying output for ITC bookings.
 * Contains zero business logic.
 */
public class BookingView {

    private static final int WIDTH = 60;

    private String border(String left, String fill, String right) {
        return left + fill.repeat(WIDTH) + right;
    }

    private String row(String content) {
        int spaces = WIDTH - content.length() - 2;
        if (spaces < 0) spaces = 0;
        return "║  " + content + " ".repeat(spaces) + "║";
    }

    public void showBookingDetails(Booking booking) {
        String tid = booking.getTicket().getType();
        String rt  = booking.getTicket().getRoute();
        String dep = booking.getTicket().getDepartureTime();
        String pri = "NGN " + booking.getTicket().getPrice();

        System.out.println();
        System.out.println(border("╔", "═", "╗"));
        System.out.println(row("         ITC BOOKING CONFIRMATION"));
        System.out.println(border("╠", "═", "╣"));
        System.out.println(row("Booking ID  : " + booking.getBookingId()));
        System.out.println(row("Name        : " + booking.getPassenger().getName()));
        System.out.println(row("Phone       : " + booking.getPassenger().getPhone()));
        System.out.println(row("NIC         : " + booking.getPassenger().getNic()));
        System.out.println(border("╠", "-", "╣"));
        System.out.println(row("Ticket      : " + tid));
        System.out.println(row("Route       : " + rt));
        System.out.println(row("Departs     : " + dep));
        System.out.println(row("Price       : " + pri));
        System.out.println(border("╠", "-", "╣"));
        System.out.println(row("Seat No.    : " + booking.getSeatNumber()));
        System.out.println(row("Status      : " + booking.getStatus()));
        System.out.println(border("╚", "═", "╝"));
    }

    public void showMessage(String message) {
        System.out.println("\n[View] " + message);
    }

    public void showError(String error) {
        System.out.println("\n[View] ERROR -- " + error);
    }
}
