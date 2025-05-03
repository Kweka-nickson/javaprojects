import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    static class Task {
        int id;
        String description;
        boolean completed;

        Task(int id, String description) {
            this.id = id;
            this.description = description;
            this.completed = false;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Description: " + description + ", Completed: " + completed;
        }
    }

    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void createTask(String description) {
        tasks.add(new Task(nextId++, description));
        System.out.println("Task added!");
    }

    public void readTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks!");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void updateTask(int id, String description, boolean completed) {
        for (Task task : tasks) {
            if (task.id == id) {
                task.description = description;
                task.completed = completed;
                System.out.println("Task updated!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).id == id) {
                tasks.remove(i);
                System.out.println("Task deleted!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager CRUD");
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter task description: ");
                String description = scanner.nextLine();
                manager.createTask(description);
            } else if (choice == 2) {
                manager.readTasks();
            } else if (choice == 3) {
                System.out.print("Enter task ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new description: ");
                String description = scanner.nextLine();
                System.out.print("Is task completed? (true/false): ");
                boolean completed = scanner.nextBoolean();
                manager.updateTask(id, description, completed);
            } else if (choice == 4) {
                System.out.print("Enter task ID to delete: ");
                int id = scanner.nextInt();
                manager.deleteTask(id);
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