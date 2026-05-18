package decorator;

import model.Ticket;

/**
 * STRUCTURAL - Decorator Pattern (Concrete).
 * Adds travel insurance to any ITC ticket.
 * Appends "+ Insurance" to ticket type and adds NGN 300 to price.
 */
public class InsuranceDecorator extends TicketDecorator {
    private static final double INSURANCE_PRICE = 300.0;

    public InsuranceDecorator(Ticket ticket) { super(ticket); }

    @Override
    public String getType()  { return wrappedTicket.getType() + " + Insurance"; }

    @Override
    public double getPrice() { return wrappedTicket.getPrice() + INSURANCE_PRICE; }
}
