import java.util.ArrayList;
import java.util.Scanner;

public class InventorySystem {
    static class Item {
        int id;
        String name;
        int quantity;

        Item(int id, String name, int quantity) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
        }
    }

    private ArrayList<Item> items = new ArrayList<>();
    private int nextId = 1;

    public void createItem(String name, int quantity) {
        items.add(new Item(nextId++, name, quantity));
        System.out.println("Item added!");
    }

    public void readItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory!");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void updateItem(int id, String name, int quantity) {
        for (Item item : items) {
            if (item.id == id) {
                item.name = name;
                item.quantity = quantity;
                System.out.println("Item updated!");
                return;
            }
        }
        System.out.println("Item not found!");
    }

    public void deleteItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id == id) {
                items.remove(i);
                System.out.println("Item deleted!");
                return;
            }
        }
        System.out.println("Item not found!");
    }

    public static void main(String[] args) {
        InventorySystem inventory = new InventorySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory System CRUD");
            System.out.println("1. Create Item");
            System.out.println("2. Read Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                inventory.createItem(name, quantity);
            } else if (choice == 2) {
                inventory.readItems();
            } else if (choice == 3) {
                System.out.print("Enter item ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                inventory.updateItem(id, name, quantity);
            } else if (choice == 4) {
                System.out.print("Enter item ID to delete: ");
                int id = scanner.nextInt();
                inventory.deleteItem(id);
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}