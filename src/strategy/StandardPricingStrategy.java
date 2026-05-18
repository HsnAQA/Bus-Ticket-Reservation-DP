package strategy;

/** BEHAVIORAL - Strategy: no change to base price. */
public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        System.out.println("  [Strategy] Standard - no change. NGN " + basePrice);
        return basePrice;
    }
}
