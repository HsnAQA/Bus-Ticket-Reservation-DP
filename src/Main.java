import controller.BookingController;
import decorator.InsuranceDecorator;
import decorator.MealDecorator;
import factory.TicketFactory;
import model.Passenger;
import model.Ticket;
import singleton.DatabaseConnection;
import strategy.ExpressPricingStrategy;
import strategy.StandardPricingStrategy;
import strategy.VIPPricingStrategy;
import view.BookingView;

/**
 * Entry point for the OBTRS - Online Bus Ticket Reservation System.
 * Case Study: Imo Transport Company (ITC), Owerri, Nigeria.
 * Reference: Mehra et al. (2021), IRJMETS Vol.03 Issue 05.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║   OBTRS - Online Bus Ticket Reservation System    ║");
        System.out.println("║   Imo Transport Company (ITC) - Owerri, Nigeria   ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        // Singleton: one DB connection for the entire application
        DatabaseConnection db = DatabaseConnection.getInstance();
        System.out.println("[Main] DB ready: " + db.isConnected() + "\n");

        // MVC setup
        BookingView view = new BookingView();
        BookingController controller = new BookingController(view);

        // Booking 1: Chukwu - Standard, Lagos to Owerri, seat 12
        Passenger p1 = new Passenger("Chukwu Emeka", "08031234567", "NG-1234567890");
        controller.processBooking("BK-001", p1,
            TicketFactory.STANDARD, "Lagos-Owerri", "07:00 AM",
            12, new StandardPricingStrategy());

        // Booking 2: Ngozi - VIP, Abuja to Port Harcourt, seat 3
        Passenger p2 = new Passenger("Ngozi Okonkwo", "08059876543", "NG-9876543210");
        controller.processBooking("BK-002", p2,
            TicketFactory.VIP, "Abuja-PortHarcourt", "09:00 AM",
            3, new VIPPricingStrategy());

        // Decorator Demo: Express ticket with Meal and Insurance add-ons
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║   Decorator Pattern Demo                          ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        Ticket base     = TicketFactory.createTicket(TicketFactory.EXPRESS, "T-003", "Lagos-Abuja", "02:00 PM");
        Ticket withMeal = new MealDecorator(base);
        Ticket withBoth = new InsuranceDecorator(withMeal);
        System.out.println("  Base ticket        : " + base);
        System.out.println("  + Meal             : " + withMeal);
        System.out.println("  + Meal + Insurance : " + withBoth);

        // Booking 3: Tunde - invalid seat 99 (Proxy blocks it)
        Passenger p3 = new Passenger("Tunde Balogun", "07031112222", "NG-1122334455");
        controller.processBooking("BK-003", p3,
            TicketFactory.STANDARD, "Owerri-Enugu", "05:00 PM",
            99, new ExpressPricingStrategy());
    }
}
