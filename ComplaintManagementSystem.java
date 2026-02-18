import java.util.ArrayList;
import java.util.Scanner;

public class ComplaintManagementSystem {
    private static ArrayList<Complaint> complaints = new ArrayList<>();
    private static int complaintCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Complaint Management System ===");
            System.out.println("1. Register Complaint");
            System.out.println("2. View All Complaints");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerComplaint(sc);
                    break;
                case 2:
                    viewComplaints();
                    break;
                case 3:
                    updateStatus(sc);
                    break;
                case 4:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void registerComplaint(Scanner sc) {
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Complaint Description: ");
        String desc = sc.nextLine();

        Complaint complaint = new Complaint(complaintCounter++, name, desc);
        complaints.add(complaint);

        System.out.println("Complaint Registered Successfully!");
    }

    private static void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        for (Complaint c : complaints) {
            c.displayComplaint();
        }
    }

    private static void updateStatus(Scanner sc) {
        System.out.print("Enter Complaint ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Complaint c : complaints) {
            if (c.getId() == id) {
                System.out.print("Enter New Status (In Progress / Resolved): ");
                String status = sc.nextLine();
                c.setStatus(status);
                System.out.println("Status Updated Successfully!");
                return;
            }
        }

        System.out.println("Complaint ID not found!");
    }
}
