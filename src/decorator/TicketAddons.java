package decorator;

import model.Ticket;

/**
 * STRUCTURAL — Decorator Pattern (Concrete Decorators)
 * MealDecorator adds a meal service (+SAR 25) to any ticket.
 * InsuranceDecorator adds travel insurance (+SAR 15) to any ticket.
 * They can be stacked: new InsuranceDecorator(new MealDecorator(ticket))
 */

class MealDecorator extends TicketDecorator {
    private static final double MEAL_PRICE = 25.0;
    public MealDecorator(Ticket ticket) { super(ticket); }

    @Override public String getType()  { return wrappedTicket.getType() + " + Meal"; }
    @Override public double getPrice() { return wrappedTicket.getPrice() + MEAL_PRICE; }
}

class InsuranceDecorator extends TicketDecorator {
    private static final double INSURANCE_PRICE = 15.0;
    public InsuranceDecorator(Ticket ticket) { super(ticket); }

    @Override public String getType()  { return wrappedTicket.getType() + " + Insurance"; }
    @Override public double getPrice() { return wrappedTicket.getPrice() + INSURANCE_PRICE; }
}
