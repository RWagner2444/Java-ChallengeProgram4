
/**
 * Merge Sort Challenge Program
 * 5-22-2021
 * Ryan Wagners
 */
public class StoreItem
{
    private String name;
    private String productNumber;
    private double price;
    private int quantity;
    
    public StoreItem(String name, String productNumber, double price, int quantity)
    {
        this.name = name;
        this.productNumber = productNumber;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){
        return name;
    }
    
    public String getProductNumber(){
        return productNumber;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String toString(){
        return String.format("%-20s %-15s %s %.2f %10s", name, productNumber, "$", price, quantity);
    }
}
