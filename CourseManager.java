import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
    static class Course {
        int id;
        String name;
        String instructor;

        Course(int id, String name, String instructor) {
            this.id = id;
            this.name = name;
            this.instructor = instructor;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Instructor: " + instructor;
        }
    }

    private ArrayList<Course> courses = new ArrayList<>();
    private int nextId = 1;

    public void createCourse(String name, String instructor) {
        courses.add(new Course(nextId++, name, instructor));
        System.out.println("Course added!");
    }

    public void readCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses!");
        } else {
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }

    public void updateCourse(int id, String name, String instructor) {
        for (Course course : courses) {
            if (course.id == id) {
                course.name = name;
                course.instructor = instructor;
                System.out.println("Course updated!");
                return;
            }
        }
        System.out.println("Course not found!");
    }

    public void deleteCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).id == id) {
                courses.remove(i);
                System.out.println("Course deleted!");
                return;
            }
        }
        System.out.println("Course not found!");
    }

    public static void main(String[] args) {
        CourseManager manager = new CourseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCourse Manager CRUD");
            System.out.println("1. Create Course");
            System.out.println("2. Read Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter course name: ");
                String name = scanner.nextLine();
                System.out.print("Enter instructor: ");
                String instructor = scanner.nextLine();
                manager.createCourse(name, instructor);
            } else if (choice == 2) {
                manager.readCourses();
            } else if (choice == 3) {
                System.out.print("Enter course ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new instructor: ");
                String instructor = scanner.nextLine();
                manager.updateCourse(id, name, instructor);
            } else if (choice == 4) {
                System.out.print("Enter course ID to delete: ");
                int id = scanner.nextInt();
                manager.deleteCourse(id);
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