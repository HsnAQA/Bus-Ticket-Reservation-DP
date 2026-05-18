package strategy;

/** BEHAVIORAL - Strategy: adds 10% surcharge for Express tickets. */
public class ExpressPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        double price = basePrice * 1.10;
        System.out.println("  [Strategy] Express (+10%) - NGN " + basePrice + " -> NGN " + price);
        return price;
    }
}
