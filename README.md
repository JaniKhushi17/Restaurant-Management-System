# 🍽️ Restaurant Management System (Java Console App)

This is a simple **Java-based console application** for managing a restaurant's menu, placing and modifying orders, and generating bills. It's designed to simulate basic restaurant operations in a user-friendly command-line interface.

---

## 🧠 Features

- View menu items
- Place an order using item IDs
- Display all orders with totals
- Generate a detailed bill for any order
- Modify an existing order (add or remove items)
- Exit the application gracefully

---

## 🧩 Components & Classes

### 🔹 `MenuItem`
Represents a single item in the menu with:
- Name
- Price

### 🔹 `Order`
Represents a customer's order containing:
- List of menu items
- Method to calculate total cost
- (In extended version) Methods to remove or modify items

### 🔹 `Restaurant`
Handles core functionalities:
- Adding/displaying menu
- Placing/modifying orders
- Generating bills
- Maintaining all orders

### 🔹 `RestaurantManagementSystem` (Main class)
Provides the interactive CLI menu using `Scanner`:
- Lets the user select options like view menu, order, modify, bill generation, etc.

---

## 📋 Sample Menu Options (CLI)
1. Display Menu
2. Place Order
3. Display Orders
4. Exit
5. Generate Bill for an Order
6. Modify an Existing Order

## 🚀 How to Run

1. Save the file as `RestaurantManagementSystem.java`
2. Compile the program:
```bash
  javac RestaurantManagementSystem.java
```
3. Run the program:
```bash
java RestaurantManagementSystem
```

## 🔧 Possible Improvements
- Add item descriptions and categories (e.g., drinks, main course)
- Save/load orders from file (persistence)
- Apply taxes and discounts
- Implement a login system for staff/admin
- GUI version using JavaFX or Swing

## 📎 Example Output
```bash
Menu:
1. Burger - $8.99
2. Pizza - $10.99
3. Salad - $6.99

Order #1 placed.
Order #1 Total: $19.98

Bill for Order #1:
Burger - $8.99
Pizza - $10.99
Total: $19.98
```

📝 License
This project is for educational use. You are free to modify and enhance it.
