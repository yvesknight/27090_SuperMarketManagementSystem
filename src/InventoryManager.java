public class InventoryManager extends Product implements Sellable {
    private String supplierName;
    private String storageLocation;

    public InventoryManager() { super(); }

    public InventoryManager(String productId, String productName, double price, int quantity,
                            String category, String supplierName, String storageLocation) {
        super(productId, productName, price, quantity, category);
        this.supplierName = supplierName;
        this.storageLocation = storageLocation;
    }

    public String getSupplierName() { return supplierName; }
    public String getStorageLocation() { return storageLocation; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
    public void setStorageLocation(String storageLocation) { this.storageLocation = storageLocation; }

    @Override public double calculateDiscount() { return getPrice() * 0.05; }
    @Override public double applyTax() { return getPrice() * 1.18; }
    @Override public boolean checkAvailability() { return getQuantity() > 0; }
    @Override public double calculateTotalValue() { return getPrice() * getQuantity(); }
    @Override public void updateStock(int amount) { setQuantity(getQuantity() + amount); }
    @Override public boolean validateProduct() {
        return getProductId() != null && !getProductId().isEmpty()
                && getPrice() > 0 && getQuantity() >= 0;
    }
    @Override public String generateReport() {
        return String.format("Report[%s]: %s | Stock: %d | Value: %.2f",
                getProductId(), getProductName(), getQuantity(), calculateTotalValue());
    }
    @Override public String getCategoryDescription() { return "General inventory item: " + getCategory(); }

    @Override public void processSale(int quantity) {
        if (quantity > getQuantity()) throw new IllegalArgumentException("Insufficient stock.");
        updateStock(-quantity);
    }
    @Override public double calculateFinalPrice(int quantity) {
        return (applyTax() - calculateDiscount()) * quantity;
    }
    @Override public void printReceipt(String customerName, int quantity) {
        System.out.println("===== RECEIPT =====");
        System.out.println("Customer : " + customerName);
        System.out.println("Product  : " + getProductName());
        System.out.println("Qty      : " + quantity);
        System.out.printf("Total    : %.2f RWF%n", calculateFinalPrice(quantity));
        System.out.println("===================");
    }

    @Override public String toString() {
        return super.toString() + String.format(" | Supplier: %s | Location: %s", supplierName, storageLocation);
    }
}
