# 27090 – Advanced Supermarket Management System

A console-based Java application that simulates a real-world supermarket management system. Built as an OOP assignment demonstrating **Encapsulation, Abstraction, Inheritance, Polymorphism, and Interfaces**.

---

## Table of Contents
- [Overview](#overview)
- [Project Structure](#project-structure)
- [OOP Concepts Demonstrated](#oop-concepts-demonstrated)
- [Class Descriptions](#class-descriptions)
- [How to Run](#how-to-run)
  - [Option 1: Run the JAR directly](#option-1-run-the-jar-directly)
  - [Option 2: Compile and run from source](#option-2-compile-and-run-from-source)
  - [Option 3: Run with Docker](#option-3-run-with-docker)
- [Input Validation](#input-validation)
- [Product Categories](#product-categories)
- [Sample Flow](#sample-flow)
- [Requirements](#requirements)

---

## Overview

The system allows a user to:
1. Register a product (choose from 6 categories)
2. Register a customer
3. Place an order
4. View a full receipt with tax, discount, and total price applied

---

## Project Structure

```
27090_SuperMarketManagementSystem/
├── src/
│   ├── Product.java               # Abstract base class
│   ├── Sellable.java              # Interface
│   ├── InventoryManager.java      # Extends Product, implements Sellable
│   ├── FoodProduct.java           # Subclass – expiry date
│   ├── BeverageProduct.java       # Subclass – volume (ml)
│   ├── ElectronicProduct.java     # Subclass – warranty (months)
│   ├── ClothingProduct.java       # Subclass – size
│   ├── CleaningProduct.java       # Subclass – hazard level
│   ├── PersonalCareProduct.java   # Subclass – skin type
│   ├── Customer.java              # Customer data class
│   ├── Order.java                 # Order data class
│   ├── InputValidator.java        # All input validation logic
│   ├── ProductFactory.java        # Factory pattern – creates products by category
│   └── SupermarketSystem.java     # Main class – entry point
├── SupermarketSystem.jar          # Runnable JAR
├── Dockerfile                     # Docker build & run config
├── MANIFEST.MF                    # JAR manifest
└── README.md
```

---

## OOP Concepts Demonstrated

| Concept | Where Applied |
|---|---|
| **Encapsulation** | All attributes are `private` with getters/setters in every class |
| **Abstraction** | `Product` is abstract with 8 abstract methods |
| **Interface** | `Sellable` defines `processSale`, `calculateFinalPrice`, `printReceipt` |
| **Inheritance** | 6 subclasses → `InventoryManager` → `Product` |
| **Polymorphism** | `ProductFactory` returns `InventoryManager` references to subclass objects; each overrides discount/tax/description |
| **Method Overriding** | `toString()`, `calculateDiscount()`, `applyTax()`, `getCategoryDescription()` overridden per subclass |
| **Constructors** | Default and parameterized constructors in every class |

---

## Class Descriptions

### `Product` (Abstract)
Base class with 5 private attributes: `productId`, `productName`, `price`, `quantity`, `category`.
Declares 8 abstract methods: `calculateDiscount()`, `applyTax()`, `checkAvailability()`, `calculateTotalValue()`, `updateStock()`, `validateProduct()`, `generateReport()`, `getCategoryDescription()`.

### `Sellable` (Interface)
Defines the contract for sellable items: `processSale()`, `calculateFinalPrice()`, `printReceipt()`.

### `InventoryManager`
Extends `Product`, implements `Sellable`. Adds `supplierName` and `storageLocation`. Provides base implementations for all abstract and interface methods.

### Product Subclasses
Each extends `InventoryManager`, adds one specific attribute, and overrides at least 3 methods:

| Class | Extra Attribute | Discount | Tax |
|---|---|---|---|
| `FoodProduct` | `expiryDate` | 10% | 8% |
| `BeverageProduct` | `volumeMl` | 8% | 10% |
| `ElectronicProduct` | `warrantyMonths` | 3% | 20% |
| `ClothingProduct` | `size` | 15% | 12% |
| `CleaningProduct` | `hazardLevel` | 5% | 15% |
| `PersonalCareProduct` | `skinType` | 7% | 10% |

### `Customer`
Holds `customerId`, `customerName`, `phoneNumber`.

### `Order`
Holds `orderId`, `product`, `quantityPurchased`. Auto-calculates `totalPrice` via `calculateTotalPrice()`.

### `InputValidator`
Pure validation logic — every method takes a `String` and returns an error message or `null` if valid. Handles: empty input, non-numeric values, negative numbers, oversized values, invalid phone format, duplicate IDs, special characters.

### `ProductFactory`
Creates the correct product subclass based on a category string — demonstrates polymorphism.

---

## How to Run

### Option 1: Run the JAR directly
> Requires Java 17 or higher

```bash
java -jar SupermarketSystem.jar
```

### Option 2: Compile and run from source
> Requires JDK 17 or higher

```bash
# Compile
javac -d out src/*.java

# Run
java -cp out SupermarketSystem
```

### Option 3: Run with Docker
> Requires Docker installed

```bash
# Build the image
docker build -t supermarket-system .

# Run the container (interactive mode required for console input)
docker run -it supermarket-system
```

---

## Input Validation

The system validates all user input and re-prompts on error:

| Validation | Rule |
|---|---|
| Empty input | Not allowed anywhere |
| Product/Customer/Order ID | Alphanumeric + hyphens only, no spaces, must be unique |
| Price | Positive number, max 1,000,000 |
| Quantity | Non-negative integer, max 100,000 |
| Phone number | Rwandan format: `07[2/3/8/9]XXXXXXX` |
| Category | Must be one of the 6 valid categories |
| Customer name | Letters and spaces only |
| Order quantity | Cannot exceed available stock |

---

## Product Categories

When prompted, enter one of the following (case-insensitive):

- `Food`
- `Beverage`
- `Electronic`
- `Clothing`
- `Cleaning`
- `PersonalCare`

---

## Sample Flow

```
========================================
   ADVANCED SUPERMARKET MANAGEMENT SYSTEM
========================================

--- PRODUCT REGISTRATION ---
Enter category: Food
Enter Product ID: P001
Enter Product Name: White Rice
Enter Price (RWF): 2500
Enter Quantity in stock: 100
Enter Supplier Name: Rwanda Foods Ltd
Enter Storage Location: Aisle 3
Enter Expiry Date: 2026-01-01

--- PRODUCT DETAILS ---
ID: P001 | Name: White Rice | Price: 2500.00 | Qty: 100 | Category: Food
Category Info : Perishable food item. Expires: 2026-01-01
Total Value   : 250000.00 RWF

--- CUSTOMER REGISTRATION ---
Enter Customer ID: C001
Enter Customer Name: Jean Pierre
Enter Phone Number: 0781234567

--- ORDER PROCESSING ---
Enter quantity to purchase: 3
Enter Order ID: ORD001

===== RECEIPT =====
Customer : Jean Pierre
Product  : White Rice
Qty      : 3
Total    : 7200.00 RWF
===================
```

---

## Requirements

- Java 17+
- Docker (optional, for containerized run)

---

**Name:** Yves IRADUKUNDA GATABAZI
**ID:** 27090
**Course:** Object-Oriented Programming  
**School:** AUCA  
