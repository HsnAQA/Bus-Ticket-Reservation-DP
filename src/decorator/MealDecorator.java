package decorator;

import model.Ticket;

/**
 * STRUCTURAL - Decorator Pattern (Concrete).
 * Adds an in-transit meal service to any ITC ticket.
 * Appends "+ Meal" to ticket type and adds NGN 500 to price.
 */
public class MealDecorator extends TicketDecorator {
    private static final double MEAL_PRICE = 500.0;

    public MealDecorator(Ticket ticket) { super(ticket); }

    @Override
    public String getType()  { return wrappedTicket.getType() + " + Meal"; }

    @Override
    public double getPrice() { return wrappedTicket.getPrice() + MEAL_PRICE; }
}
