import java.util.ArrayList;
import java.util.Scanner;

public class BookLibrary {
    static class Book {
        int id;
        String title;
        String author;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Title: " + title + ", Author: " + author;
        }
    }

    private ArrayList<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void createBook(String title, String author) {
        books.add(new Book(nextId++, title, author));
        System.out.println("Book added!");
    }

    public void readBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void updateBook(int id, String title, String author) {
        for (Book book : books) {
            if (book.id == id) {
                book.title = title;
                book.author = author;
                System.out.println("Book updated!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == id) {
                books.remove(i);
                System.out.println("Book deleted!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public static void main(String[] args) {
        BookLibrary library = new BookLibrary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Library CRUD");
            System.out.println("1. Create Book");
            System.out.println("2. Read Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                library.createBook(title, author);
            } else if (choice == 2) {
                library.readBooks();
            } else if (choice == 3) {
                System.out.print("Enter book ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new title: ");
                String title = scanner.nextLine();
                System.out.print("Enter new author: ");
                String author = scanner.nextLine();
                library.updateBook(id, title, author);
            } else if (choice == 4) {
                System.out.print("Enter book ID to delete: ");
                int id = scanner.nextInt();
                library.deleteBook(id);
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