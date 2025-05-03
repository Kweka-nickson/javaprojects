import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {
    static class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Salary: $" + salary;
        }
    }

    private HashMap<Integer, Employee> employees = new HashMap<>();
    private int nextId = 1;

    public void createEmployee(String name, double salary) {
        employees.put(nextId, new Employee(name, salary));
        System.out.println("Employee added with ID: " + nextId);
        nextId++;
    }

    public void readEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees!");
        } else {
            for (Integer id : employees.keySet()) {
                System.out.println("ID: " + id + ", " + employees.get(id));
            }
        }
    }

    public void updateEmployee(int id, String name, double salary) {
        if (employees.containsKey(id)) {
            employees.put(id, new Employee(name, salary));
            System.out.println("Employee updated!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    public void deleteEmployee(int id) {
        if (employees.remove(id) != null) {
            System.out.println("Employee deleted!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Manager CRUD");
            System.out.println("1. Create Employee");
            System.out.println("2. Read Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter salary: ");
                double salary = scanner.nextDouble();
                manager.createEmployee(name, salary);
            } else if (choice == 2) {
                manager.readEmployees();
            } else if (choice == 3) {
                System.out.print("Enter employee ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new salary: ");
                double salary = scanner.nextDouble();
                manager.updateEmployee(id, name, salary);
            } else if (choice == 4) {
                System.out.print("Enter employee ID to delete: ");
                int id = scanner.nextInt();
                manager.deleteEmployee(id);
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