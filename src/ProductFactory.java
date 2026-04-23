public class ProductFactory {

    public static InventoryManager createProduct(String category,
                                                  String id, String name, double price, int quantity,
                                                  String supplier, String location,
                                                  String extraAttribute) {
        return switch (category.toLowerCase()) {
            case "food"         -> new FoodProduct(id, name, price, quantity, supplier, location, extraAttribute);
            case "beverage"     -> new BeverageProduct(id, name, price, quantity, supplier, location, Double.parseDouble(extraAttribute));
            case "electronic"   -> new ElectronicProduct(id, name, price, quantity, supplier, location, Integer.parseInt(extraAttribute));
            case "clothing"     -> new ClothingProduct(id, name, price, quantity, supplier, location, extraAttribute);
            case "cleaning"     -> new CleaningProduct(id, name, price, quantity, supplier, location, extraAttribute);
            case "personalcare" -> new PersonalCareProduct(id, name, price, quantity, supplier, location, extraAttribute);
            default             -> throw new IllegalArgumentException("Unknown category: " + category);
        };
    }
}
