import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static class Student {
        String name;
        int rollNumber;
        double grade;
        
        Student(String name, int rollNumber, double grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }
        
        @Override
        public String toString() {
            return "Roll: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter roll number: ");
                int roll = scanner.nextInt();
                System.out.print("Enter grade: ");
                double grade = scanner.nextDouble();
                students.add(new Student(name, roll, grade));
                System.out.println("Student added!");
            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No students!");
                } else {
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}