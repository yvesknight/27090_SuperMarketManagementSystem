public class FoodProduct extends InventoryManager {
    private String expiryDate;

    public FoodProduct() { super(); }

    public FoodProduct(String productId, String productName, double price, int quantity,
                       String supplierName, String storageLocation, String expiryDate) {
        super(productId, productName, price, quantity, "Food", supplierName, storageLocation);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    @Override public double calculateDiscount() { return getPrice() * 0.10; }
    @Override public double applyTax() { return getPrice() * 1.08; }
    @Override public String getCategoryDescription() { return "Perishable food item. Expires: " + expiryDate; }

    @Override public String toString() {
        return super.toString() + " | Expiry: " + expiryDate;
    }
}
