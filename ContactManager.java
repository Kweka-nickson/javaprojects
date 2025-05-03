import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    static class Contact {
        int id;
        String name;
        String phone;

        Contact(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Phone: " + phone;
        }
    }

    private ArrayList<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    public void createContact(String name, String phone) {
        contacts.add(new Contact(nextId++, name, phone));
        System.out.println("Contact added!");
    }

    public void readContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts!");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void updateContact(int id, String name, String phone) {
        for (Contact contact : contacts) {
            if (contact.id == id) {
                contact.name = name;
                contact.phone = phone;
                System.out.println("Contact updated!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public void deleteContact(int id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).id == id) {
                contacts.remove(i);
                System.out.println("Contact deleted!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Manager CRUD");
            System.out.println("1. Create Contact");
            System.out.println("2. Read Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();
                manager.createContact(name, phone);
            } else if (choice == 2) {
                manager.readContacts();
            } else if (choice == 3) {
                System.out.print("Enter contact ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new phone: ");
                String phone = scanner.nextLine();
                manager.updateContact(id, name, phone);
            } else if (choice == 4) {
                System.out.print("Enter contact ID to delete: ");
                int id = scanner.nextInt();
                manager.deleteContact(id);
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