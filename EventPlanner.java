import java.util.ArrayList;
import java.util.Scanner;

public class EventPlanner {
    static class Event {
        int id;
        String name;
        String date;

        Event(int id, String name, String date) {
            this.id = id;
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Date: " + date;
        }
    }

    private ArrayList<Event> events = new ArrayList<>();
    private int nextId = 1;

    public void createEvent(String name, String date) {
        events.add(new Event(nextId++, name, date));
        System.out.println("Event added!");
    }

    public void readEvents() {
        if (events.isEmpty()) {
            System.out.println("No events!");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public void updateEvent(int id, String name, String date) {
        for (Event event : events) {
            if (event.id == id) {
                event.name = name;
                event.date = date;
                System.out.println("Event updated!");
                return;
            }
        }
        System.out.println("Event not found!");
    }

    public void deleteEvent(int id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).id == id) {
                events.remove(i);
                System.out.println("Event deleted!");
                return;
            }
        }
        System.out.println("Event not found!");
    }

    public static void main(String[] args) {
        EventPlanner planner = new EventPlanner();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEvent Planner CRUD");
            System.out.println("1. Create Event");
            System.out.println("2. Read Events");
            System.out.println("3. Update Event");
            System.out.println("4. Delete Event");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter event name: ");
                String name = scanner.nextLine();
                System.out.print("Enter event date (e.g., YYYY-MM-DD): ");
                String date = scanner.nextLine();
                planner.createEvent(name, date);
            } else if (choice == 2) {
                planner.readEvents();
            } else if (choice == 3) {
                System.out.print("Enter event ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new date: ");
                String date = scanner.nextLine();
                planner.updateEvent(id, name, date);
            } else if (choice == 4) {
                System.out.print("Enter event ID to delete: ");
                int id = scanner.nextInt();
                planner.deleteEvent(id);
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