package strategy;

/**
 * BEHAVIORAL - Strategy Pattern (Interface).
 * Defines the pricing contract. Swap strategies at runtime without changing any other code.
 * Implemented by: StandardPricingStrategy, VIPPricingStrategy, ExpressPricingStrategy.
 */
public interface PricingStrategy {
    double calculatePrice(double basePrice);
}
