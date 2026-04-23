public abstract class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String category;

    public Product() {}

    public Product(String productId, String productName, double price, int quantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getters
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    // Setters
    public void setProductId(String productId) { this.productId = productId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setCategory(String category) { this.category = category; }

    // Abstract methods
    public abstract double calculateDiscount();
    public abstract double applyTax();
    public abstract boolean checkAvailability();
    public abstract double calculateTotalValue();
    public abstract void updateStock(int amount);
    public abstract boolean validateProduct();
    public abstract String generateReport();
    public abstract String getCategoryDescription();

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Price: %.2f | Qty: %d | Category: %s",
                productId, productName, price, quantity, category);
    }
}
