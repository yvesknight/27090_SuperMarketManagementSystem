public interface Sellable {
    void processSale(int quantity);
    double calculateFinalPrice(int quantity);
    void printReceipt(String customerName, int quantity);
}
