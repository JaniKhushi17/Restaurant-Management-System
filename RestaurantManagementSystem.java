import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

class Restaurant {
    private Map<Integer, MenuItem> menu = new HashMap<>();
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    public void addMenuItem(int id, String name, double price) {
        menu.put(id, new MenuItem(name, price));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (Map.Entry<Integer, MenuItem> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName() + " - $" + entry.getValue().getPrice());
        }
    }

    public void placeOrder(List<Integer> itemIds) {
        Order order = new Order();
        for (int itemId : itemIds) {
            if (menu.containsKey(itemId)) {
                order.addItem(menu.get(itemId));
            }
        }
        orders.add(order);
        System.out.println("Order #" + orderCounter + " placed.");
        orderCounter++;
    }

    public void displayOrders() {
        System.out.println("Orders:");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Order #" + (i + 1) + " Total: $" + orders.get(i).calculateTotal());
        }
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.addMenuItem(1, "Burger", 8.99);
        restaurant.addMenuItem(2, "Pizza", 10.99);
        restaurant.addMenuItem(3, "Salad", 6.99);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Display Orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    restaurant.displayMenu();
                    break;
                case 2:
                    restaurant.displayMenu();
                    System.out.print("Enter item IDs (comma-separated): ");
                    scanner.nextLine(); // Consume newline
                    String[] itemIdsStr = scanner.nextLine().split(",");
                    List<Integer> itemIds = new ArrayList<>();
                    for (String itemId : itemIdsStr) {
                        itemIds.add(Integer.parseInt(itemId.trim()));
                    }
                    restaurant.placeOrder(itemIds);
                    break;
                case 3:
                    restaurant.displayOrders();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
// ... (previous code)
/* 
class Restaurant {
    // ... (previous code)

    public void generateBill(int orderNumber) {
        if (orderNumber >= 1 && orderNumber <= orders.size()) {
            Order order = orders.get(orderNumber - 1);
            double total = order.calculateTotal();
            System.out.println("Bill for Order #" + orderNumber);
            for (MenuItem item : order.getItems()) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
            System.out.println("Total: $" + total);
        } else {
            System.out.println("Invalid order number");
        }
    }
}

public class RestaurantManagementSystem {
    // ... (previous code)

    public static void main(String[] args) {
        // ... (previous code)

        while (true) {
            // ... (previous code)

            switch (choice) {
                // ... (previous cases)

                case 5:
                    System.out.print("Enter order number to generate bill: ");
                    int orderNumber = scanner.nextInt();
                    restaurant.generateBill(orderNumber);
                    break;

                // ... (previous cases)
            }
        }
    }
}

// ... (previous code)

class Restaurant {
    // ... (previous code)

    public void modifyOrder(int orderNumber, List<Integer> newItemIds, List<Integer> removedItemIds) {
        if (orderNumber >= 1 && orderNumber <= orders.size()) {
            Order order = orders.get(orderNumber - 1);
            for (Integer itemId : removedItemIds) {
                order.removeItem(menu.get(itemId));
            }
            for (Integer itemId : newItemIds) {
                order.addItem(menu.get(itemId));
            }
            System.out.println("Order #" + orderNumber + " modified.");
        } else {
            System.out.println("Invalid order number");
        }
    }
}

public class RestaurantManagementSystem {
    // ... (previous code)

    public static void main(String[] args) {
        // ... (previous code)

        while (true) {
            // ... (previous code)

            switch (choice) {
                // ... (previous cases)

                case 6:
                    System.out.print("Enter order number to modify: ");
                    int modifyOrderNumber = scanner.nextInt();
                    restaurant.displayMenu();
                    System.out.print("Enter new item IDs to add (comma-separated): ");
                    scanner.nextLine(); // Consume newline
                    String[] newItemIdsStr = scanner.nextLine().split(",");
                    List<Integer> newItemIds = new ArrayList<>();
                    for (String itemId : newItemIdsStr) {
                        newItemIds.add(Integer.parseInt(itemId.trim()));
                    }
                    System.out.print("Enter item IDs to remove (comma-separated): ");
                    String[] removedItemIdsStr = scanner.nextLine().split(",");
                    List<Integer> removedItemIds = new ArrayList<>();
                    for (String itemId : removedItemIdsStr) {
                        removedItemIds.add(Integer.parseInt(itemId.trim()));
                    }
                    restaurant.modifyOrder(modifyOrderNumber, newItemIds, removedItemIds);
                    break;

                // ... (previous cases)
            }
        }
    }
}

*/