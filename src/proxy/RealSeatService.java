package proxy;

import singleton.DatabaseConnection;

/**
 * STRUCTURAL - Proxy Pattern (Real Subject).
 * Contains the actual seat logic. Never called directly from outside -
 * only SeatAvailabilityProxy calls it after passing validation.
 */
public class RealSeatService implements SeatService {

    @Override
    public boolean isSeatAvailable(String route, int seatNumber) {
        DatabaseConnection.getInstance().query(
            "SELECT available FROM seats WHERE route='" + route + "' AND seat_no=" + seatNumber);
        return seatNumber <= 40; // seats 1-40 are available (simulated)
    }

    @Override
    public void reserveSeat(String route, int seatNumber) {
        DatabaseConnection.getInstance().query(
            "UPDATE seats SET available=0 WHERE route='" + route + "' AND seat_no=" + seatNumber);
        System.out.println("  [Seat] Seat " + seatNumber + " reserved on route: " + route);
    }
}
