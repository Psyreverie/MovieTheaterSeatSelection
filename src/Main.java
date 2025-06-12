import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Movie Theatre Menu ---");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1 -> theatre.displaySeatingChart();
                case 2 -> {
                    System.out.print("Enter yhe seat ID to reserve (e.g., B5): ");
                    String seatId = scanner.nextLine();
                    theatre.reserveSeat(seatId);
                }
                case 3 -> {
                    System.out.print("Enter the seat ID to cancel (e.g., B5): ");
                    String seatId = scanner.nextLine();
                    theatre.cancelReservation(seatId);
                }
                case 4 -> {
                    System.out.println("Bye");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

