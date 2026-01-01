import java.util.ArrayList;
import java.util.Scanner;

public class HotelSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Predefined rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        int choice;

        do {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showAvailableRooms();
                    break;

                case 2:
                    bookRoom(sc);
                    break;

                case 3:
                    cancelBooking(sc);
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    static void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (r.isAvailable()) {
                System.out.println("Room " + r.getRoomNumber() + " - " + r.getCategory());
            }
        }
    }

    static void bookRoom(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter room number to book: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNo && r.isAvailable()) {
                r.bookRoom();
                bookings.add(new Booking(name, r));
                System.out.println("Room booked successfully!");
                return;
            }
        }

        System.out.println("Room not available.");
    }

    static void cancelBooking(Scanner sc) {
        System.out.print("Enter your name to cancel booking: ");
        String name = sc.nextLine();

        for (Booking b : bookings) {
            if (b.getCustomerName().equalsIgnoreCase(name)) {
                b.getRoom().freeRoom();
                bookings.remove(b);
                System.out.println("Booking cancelled.");
                return;
            }
        }

        System.out.println("No booking found.");
    }

    static void viewBookings() {
        System.out.println("\nCurrent Bookings:");
        for (Booking b : bookings) {
            System.out.println("Customer: " + b.getCustomerName()
                    + " | Room: " + b.getRoom().getRoomNumber()
                    + " | Category: " + b.getRoom().getCategory());
        }
    }
}
