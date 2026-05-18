package decorator;

import model.Ticket;

/**
 * STRUCTURAL - Decorator Pattern (Abstract Base).
 * Wraps any Ticket and forwards getType() and getPrice() to the wrapped ticket.
 * Concrete decorators (MealDecorator, InsuranceDecorator) extend this and add their values on top.
 */
public abstract class TicketDecorator extends Ticket {
    protected Ticket wrappedTicket;

    public TicketDecorator(Ticket ticket) {
        super(ticket.getTicketId(), ticket.getRoute(),
              ticket.getDepartureTime(), ticket.getPrice(), "BASE");
        this.wrappedTicket = ticket;
    }

    @Override
    public String getType()  { return wrappedTicket.getType(); }

    @Override
    public double getPrice() { return wrappedTicket.getPrice(); }
}
