package util;

public class TotalBillCalculator {

    public static double calculateTotal(String size, int toppings) {
        double basePrice;

        switch (size.toUpperCase()) {
            case "XL": basePrice = 15.0; break;
            case "L":  basePrice = 12.0; break;
            case "M":  basePrice = 10.0; break;
            case "S":  basePrice = 8.0;  break;
            default:   basePrice = 0.0; 
        }

        double toppingsCost = toppings * 1.5;
        double subtotal = basePrice + toppingsCost;
        double hst = subtotal * 0.15;
        return Math.round((subtotal + hst) * 100.0) / 100.0; // Rounded to 2 decimals
    }
}
