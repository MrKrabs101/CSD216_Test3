package model;

public class PizzaOrder {
    private String customerName;
    private String mobileNumber;
    private String pizzaSize;
    private int toppings;
    private double totalBill;

    public PizzaOrder(String customerName, String mobileNumber, String pizzaSize, int toppings, double totalBill) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.pizzaSize = pizzaSize;
        this.toppings = toppings;
        this.totalBill = totalBill;
    }

    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getPizzaSize() { return pizzaSize; }
    public void setPizzaSize(String pizzaSize) { this.pizzaSize = pizzaSize; }

    public int getToppings() { return toppings; }
    public void setToppings(int toppings) { this.toppings = toppings; }

    public double getTotalBill() { return totalBill; }
    public void setTotalBill(double totalBill) { this.totalBill = totalBill; }
}
