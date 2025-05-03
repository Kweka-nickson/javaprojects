import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nTo-Do List");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice == 1) {
                System.out.print("Enter task: ");
                tasks.add(scanner.nextLine());
                System.out.println("Task added!");
            } else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks!");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
            } else if (choice == 3) {
                System.out.print("Enter task number to remove: ");
                int index = scanner.nextInt() - 1;
                if (index >= 0 && index < tasks.size()) {
                    tasks.remove(index);
                    System.out.println("Task removed!");
                } else {
                    System.out.println("Invalid task number!");
                }
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}