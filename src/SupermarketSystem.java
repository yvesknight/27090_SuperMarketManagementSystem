public class SupermarketSystem {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   ADVANCED SUPERMARKET MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        // ── 1. Collect product details ──────────────────────────────────────
        System.out.println("--- PRODUCT REGISTRATION ---");
        String category = InputValidator.getValidCategory(
                "Enter category (Food/Beverage/Electronic/Clothing/Cleaning/PersonalCare): ");

        String productId   = InputValidator.getUniqueId("Enter Product ID: ");
        String productName = InputValidator.getNonEmptyString("Enter Product Name: ");
        double price       = InputValidator.getPositiveDouble("Enter Price (RWF): ");
        int    quantity    = InputValidator.getNonNegativeInt("Enter Quantity in stock: ");
        String supplier    = InputValidator.getNonEmptyString("Enter Supplier Name: ");
        String location    = InputValidator.getNonEmptyString("Enter Storage Location: ");

        String extraAttribute = collectExtraAttribute(category);

        InventoryManager product = ProductFactory.createProduct(
                category, productId, productName, price, quantity, supplier, location, extraAttribute);

        if (!product.validateProduct()) {
            System.out.println("Product validation failed. Exiting.");
            return;
        }

        System.out.println("\n--- PRODUCT DETAILS ---");
        System.out.println(product);
        System.out.println("Category Info : " + product.getCategoryDescription());
        System.out.println("Stock Report  : " + product.generateReport());
        System.out.printf("Total Value   : %.2f RWF%n", product.calculateTotalValue());
        System.out.printf("Tax Price     : %.2f RWF%n", product.applyTax());
        System.out.printf("Discount      : %.2f RWF%n", product.calculateDiscount());
        System.out.println("Available     : " + (product.checkAvailability() ? "Yes" : "No"));

        // ── 2. Collect customer details ─────────────────────────────────────
        System.out.println("\n--- CUSTOMER REGISTRATION ---");
        String customerId   = InputValidator.getUniqueId("Enter Customer ID: ");
        String customerName = InputValidator.getAlphaString("Enter Customer Name: ");
        String phone        = InputValidator.getValidPhone("Enter Phone Number (e.g. 0781234567): ");

        Customer customer = new Customer(customerId, customerName, phone);
        System.out.println("\n--- CUSTOMER DETAILS ---");
        System.out.println(customer);

        // ── 3. Process order ────────────────────────────────────────────────
        System.out.println("\n--- ORDER PROCESSING ---");
        int orderQty = 0;
        while (true) {
            orderQty = InputValidator.getPositiveInt("Enter quantity to purchase: ");
            if (orderQty > product.getQuantity()) {
                System.out.println("  Error: Only " + product.getQuantity() + " units available. Enter a smaller quantity.");
            } else {
                break;
            }
        }

        String orderId = InputValidator.getUniqueId("Enter Order ID: ");
        product.processSale(orderQty);

        Order order = new Order(orderId, product, orderQty);

        // ── 4. Display summary ──────────────────────────────────────────────
        System.out.println("\n--- ORDER SUMMARY ---");
        System.out.println(order);
        System.out.println("Remaining Stock: " + product.getQuantity());

        System.out.println();
        product.printReceipt(customer.getCustomerName(), orderQty);
    }

    private static String collectExtraAttribute(String category) {
        return switch (category.toLowerCase()) {
            case "food"         -> InputValidator.getNonEmptyString("Enter Expiry Date (e.g. 2025-12-31): ");
            case "beverage"     -> String.valueOf(InputValidator.getPositiveDouble("Enter Volume (ml): "));
            case "electronic"   -> String.valueOf(InputValidator.getPositiveInt("Enter Warranty (months): "));
            case "clothing"     -> InputValidator.getNonEmptyString("Enter Size (S/M/L/XL): ");
            case "cleaning"     -> InputValidator.getNonEmptyString("Enter Hazard Level (Low/Medium/High): ");
            case "personalcare" -> InputValidator.getNonEmptyString("Enter Skin Type (e.g. Oily/Dry/Normal): ");
            default             -> "";
        };
    }
}
