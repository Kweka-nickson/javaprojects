import java.util.ArrayList;
import java.util.Scanner;

public class ProductCatalog {
    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Price: $" + price;
        }
    }

    private ArrayList<Product> products = new ArrayList<>();
    private int nextId = 1;

    public void createProduct(String name, double price) {
        products.add(new Product(nextId++, name, price));
        System.out.println("Product added!");
    }

    public void readProducts() {
        if (products.isEmpty()) {
            System.out.println("No products!");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void updateProduct(int id, String name, double price) {
        for (Product product : products) {
            if (product.id == id) {
                product.name = name;
                product.price = price;
                System.out.println("Product updated!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id == id) {
                products.remove(i);
                System.out.println("Product deleted!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nProduct Catalog CRUD");
            System.out.println("1. Create Product");
            System.out.println("2. Read Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                catalog.createProduct(name, price);
            } else if (choice == 2) {
                catalog.readProducts();
            } else if (choice == 3) {
                System.out.print("Enter product ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new price: ");
                double price = scanner.nextDouble();
                catalog.updateProduct(id, name, price);
            } else if (choice == 4) {
                System.out.print("Enter product ID to delete: ");
                int id = scanner.nextInt();
                catalog.deleteProduct(id);
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