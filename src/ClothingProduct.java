public class ClothingProduct extends InventoryManager {
    private String size;

    public ClothingProduct() { super(); }

    public ClothingProduct(String productId, String productName, double price, int quantity,
                           String supplierName, String storageLocation, String size) {
        super(productId, productName, price, quantity, "Clothing", supplierName, storageLocation);
        this.size = size;
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    @Override public double calculateDiscount() { return getPrice() * 0.15; }
    @Override public double applyTax() { return getPrice() * 1.12; }
    @Override public String getCategoryDescription() { return "Clothing item. Size: " + size; }

    @Override public String toString() {
        return super.toString() + " | Size: " + size;
    }
}
