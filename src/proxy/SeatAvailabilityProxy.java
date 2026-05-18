package proxy;

/**
 * STRUCTURAL - Proxy Pattern (Proxy).
 * Gatekeeper for RealSeatService.
 * Validates the seat number before forwarding to the real service.
 * BookingFacade always goes through this proxy - never to RealSeatService directly.
 */
public class SeatAvailabilityProxy implements SeatService {
    private RealSeatService realService;

    public SeatAvailabilityProxy() {
        this.realService = new RealSeatService();
    }

    @Override
    public boolean isSeatAvailable(String route, int seatNumber) {
        if (seatNumber <= 0 || seatNumber > 50) {
            System.out.println("  [Proxy] BLOCKED - invalid seat number: " + seatNumber);
            return false;
        }
        System.out.println("  [Proxy] Checking seat " + seatNumber + " on route: " + route);
        return realService.isSeatAvailable(route, seatNumber);
    }

    @Override
    public void reserveSeat(String route, int seatNumber) {
        if (!isSeatAvailable(route, seatNumber)) {
            System.out.println("  [Proxy] Cannot reserve - seat unavailable.");
            return;
        }
        realService.reserveSeat(route, seatNumber);
    }
}
