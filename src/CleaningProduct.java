public class CleaningProduct extends InventoryManager {
    private String hazardLevel;

    public CleaningProduct() { super(); }

    public CleaningProduct(String productId, String productName, double price, int quantity,
                           String supplierName, String storageLocation, String hazardLevel) {
        super(productId, productName, price, quantity, "Cleaning", supplierName, storageLocation);
        this.hazardLevel = hazardLevel;
    }

    public String getHazardLevel() { return hazardLevel; }
    public void setHazardLevel(String hazardLevel) { this.hazardLevel = hazardLevel; }

    @Override public double calculateDiscount() { return getPrice() * 0.05; }
    @Override public double applyTax() { return getPrice() * 1.15; }
    @Override public String getCategoryDescription() { return "Cleaning product. Hazard level: " + hazardLevel; }

    @Override public String toString() {
        return super.toString() + " | Hazard: " + hazardLevel;
    }
}
