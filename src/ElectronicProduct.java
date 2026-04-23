public class ElectronicProduct extends InventoryManager {
    private int warrantyMonths;

    public ElectronicProduct() { super(); }

    public ElectronicProduct(String productId, String productName, double price, int quantity,
                             String supplierName, String storageLocation, int warrantyMonths) {
        super(productId, productName, price, quantity, "Electronic", supplierName, storageLocation);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }

    @Override public double calculateDiscount() { return getPrice() * 0.03; }
    @Override public double applyTax() { return getPrice() * 1.20; }
    @Override public String getCategoryDescription() { return "Electronic item. Warranty: " + warrantyMonths + " months"; }

    @Override public String toString() {
        return super.toString() + " | Warranty: " + warrantyMonths + " months";
    }
}
