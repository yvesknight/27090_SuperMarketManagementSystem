public class Order {
    private String orderId;
    private InventoryManager product;
    private int quantityPurchased;
    private double totalPrice;

    public Order() {}

    public Order(String orderId, InventoryManager product, int quantityPurchased) {
        this.orderId = orderId;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.totalPrice = calculateTotalPrice();
    }

    public double calculateTotalPrice() {
        return product.calculateFinalPrice(quantityPurchased);
    }

    public String getOrderId() { return orderId; }
    public InventoryManager getProduct() { return product; }
    public int getQuantityPurchased() { return quantityPurchased; }
    public double getTotalPrice() { return totalPrice; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setProduct(InventoryManager product) { this.product = product; }
    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
        this.totalPrice = calculateTotalPrice();
    }

    @Override public String toString() {
        return String.format("Order[%s]: %s x%d | Total: %.2f RWF",
                orderId, product.getProductName(), quantityPurchased, totalPrice);
    }
}
