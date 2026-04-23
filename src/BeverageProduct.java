public class BeverageProduct extends InventoryManager {
    private double volumeMl;

    public BeverageProduct() {
        super();
    }

    public BeverageProduct(String productId, String productName, double price, int quantity,
                           String supplierName, String storageLocation, double volumeMl) {
        super(productId, productName, price, quantity, "Beverage", supplierName, storageLocation);
        this.volumeMl = volumeMl;
    }

    public double getVolumeMl() { return volumeMl; }
    public void setVolumeMl(double volumeMl) { this.volumeMl = volumeMl; }

    @Override public double calculateDiscount() { return getPrice() * 0.08; }
    @Override public double applyTax() { return getPrice() * 1.10; }
    @Override public String getCategoryDescription() {
        return "Beverage item. Volume: " + volumeMl + "ml";
    }

    @Override public String toString() {
        return super.toString() + " | Volume: " + volumeMl + "ml";
    }
}
