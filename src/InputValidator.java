import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final java.util.Set<String> usedIds = new java.util.HashSet<>();

    public static String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("  Error: Input cannot be empty. Please try again.");
            } else {
                return input;
            }
        }
    }

    public static String getAlphaString(String prompt) {
        while (true) {
            String input = getNonEmptyString(prompt);
            if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("  Error: Only letters and spaces are allowed.");
            } else {
                return input;
            }
        }
    }

    public static double getPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) { System.out.println("  Error: Input cannot be empty."); continue; }
            try {
                double value = Double.parseDouble(input);
                if (value <= 0) { System.out.println("  Error: Value must be greater than zero."); continue; }
                if (value > 1_000_000) { System.out.println("  Error: Value is unrealistically large (max 1,000,000)."); continue; }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a valid number (e.g., 150.00).");
            }
        }
    }

    public static int getPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) { System.out.println("  Error: Input cannot be empty."); continue; }
            try {
                int value = Integer.parseInt(input);
                if (value <= 0) { System.out.println("  Error: Value must be greater than zero."); continue; }
                if (value > 100_000) { System.out.println("  Error: Value is unrealistically large (max 100,000)."); continue; }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a whole number (e.g., 10).");
            }
        }
    }

    public static int getNonNegativeInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) { System.out.println("  Error: Input cannot be empty."); continue; }
            try {
                int value = Integer.parseInt(input);
                if (value < 0) { System.out.println("  Error: Value cannot be negative."); continue; }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a whole number.");
            }
        }
    }

    public static String getValidPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) { System.out.println("  Error: Phone number cannot be empty."); continue; }
            if (!input.matches("07[2389]\\d{7}")) {
                System.out.println("  Error: Invalid phone format. Use Rwandan format e.g. 0781234567.");
            } else {
                return input;
            }
        }
    }

    public static String getUniqueId(String prompt) {
        while (true) {
            String id = getNonEmptyString(prompt);
            if (id.contains(" ")) { System.out.println("  Error: ID must not contain spaces."); continue; }
            if (!id.matches("[A-Za-z0-9\\-]+")) { System.out.println("  Error: ID must only contain letters, digits, or hyphens."); continue; }
            if (usedIds.contains(id.toUpperCase())) { System.out.println("  Error: ID '" + id + "' already exists. Use a unique ID."); continue; }
            usedIds.add(id.toUpperCase());
            return id;
        }
    }

    public static String getValidCategory(String prompt) {
        String[] valid = {"food", "beverage", "electronic", "clothing", "cleaning", "personalcare"};
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            for (String v : valid) {
                if (v.equals(input)) return input;
            }
            System.out.println("  Error: Invalid category. Choose from: Food, Beverage, Electronic, Clothing, Cleaning, PersonalCare.");
        }
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
