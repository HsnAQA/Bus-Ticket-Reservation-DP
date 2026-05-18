package proxy;

/**
 * STRUCTURAL - Proxy Pattern (Interface).
 * Contract that both RealSeatService and SeatAvailabilityProxy must follow.
 */
public interface SeatService {
    boolean isSeatAvailable(String route, int seatNumber);
    void    reserveSeat(String route, int seatNumber);
}
