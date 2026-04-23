public class PersonalCareProduct extends InventoryManager {
    private String skinType;

    public PersonalCareProduct() { super(); }

    public PersonalCareProduct(String productId, String productName, double price, int quantity,
                               String supplierName, String storageLocation, String skinType) {
        super(productId, productName, price, quantity, "PersonalCare", supplierName, storageLocation);
        this.skinType = skinType;
    }

    public String getSkinType() { return skinType; }
    public void setSkinType(String skinType) { this.skinType = skinType; }

    @Override public double calculateDiscount() { return getPrice() * 0.07; }
    @Override public double applyTax() { return getPrice() * 1.10; }
    @Override public String getCategoryDescription() { return "Personal care product. Skin type: " + skinType; }

    @Override public String toString() {
        return super.toString() + " | Skin Type: " + skinType;
    }
}
