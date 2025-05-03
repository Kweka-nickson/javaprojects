import java.util.ArrayList;
import java.util.Scanner;

public class PatientRecords {
    static class Patient {
        int id;
        String name;
        String diagnosis;

        Patient(int id, String name, String diagnosis) {
            this.id = id;
            this.name = name;
            this.diagnosis = diagnosis;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Diagnosis: " + diagnosis;
        }
    }

    private ArrayList<Patient> patients = new ArrayList<>();
    private int nextId = 1;

    public void createPatient(String name, String diagnosis) {
        patients.add(new Patient(nextId++, name, diagnosis));
        System.out.println("Patient added!");
    }

    public void readPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients!");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    public void updatePatient(int id, String name, String diagnosis) {
        for (Patient patient : patients) {
            if (patient.id == id) {
                patient.name = name;
                patient.diagnosis = diagnosis;
                System.out.println("Patient updated!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    public void deletePatient(int id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).id == id) {
                patients.remove(i);
                System.out.println("Patient deleted!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    public static void main(String[] args) {
        PatientRecords records = new PatientRecords();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPatient Records CRUD");
            System.out.println("1. Create Patient");
            System.out.println("2. Read Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter patient name: ");
                String name = scanner.nextLine();
                System.out.print("Enter diagnosis: ");
                String diagnosis = scanner.nextLine();
                records.createPatient(name, diagnosis);
            } else if (choice == 2) {
                records.readPatients();
            } else if (choice == 3) {
                System.out.print("Enter patient ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new diagnosis: ");
                String diagnosis = scanner.nextLine();
                records.updatePatient(id, name, diagnosis);
            } else if (choice == 4) {
                System.out.print("Enter patient ID to delete: ");
                int id = scanner.nextInt();
                records.deletePatient(id);
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