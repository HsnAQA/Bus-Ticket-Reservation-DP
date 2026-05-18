package strategy;

/** BEHAVIORAL - Strategy: adds 20% premium for VIP tickets. */
public class VIPPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        double price = basePrice * 1.20;
        System.out.println("  [Strategy] VIP (+20%) - NGN " + basePrice + " -> NGN " + price);
        return price;
    }
}
