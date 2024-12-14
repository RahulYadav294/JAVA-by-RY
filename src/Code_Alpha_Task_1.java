import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

 class Code_Alpha_Task_2 {
    // Room Details
    static int[] roomNumbers = {101, 102, 201, 202};
    static String[] roomCategories = {"Single", "Double", "Suite", "Deluxe"};
    static double[] roomPrices = {50.0, 75.0, 150.0, 200.0};
    static boolean[] roomAvailability = {true, true, true, true};

    // Booking Details
    static int[] bookingIds = new int[100];
    static String[] customerNames = new String[100];
    static int[] bookedRoomNumbers = new int[100];
    static Date[] checkInDates = new Date[100];
    static Date[] checkOutDates = new Date[100];
    static double[] bookingPayments = new double[100];
    static int bookingCounter = 0;

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room category to search (Single/Double/Suite/Deluxe): ");
                    String category = scanner.nextLine();
                    displayAvailableRooms(category);
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter room category (Single/Double/Suite/Deluxe): ");
                    String roomCategory = scanner.nextLine();
                    System.out.print("Enter check-in date (yyyy-MM-dd): ");
                    Date checkIn = sdf.parse(scanner.nextLine());
                    System.out.print("Enter check-out date (yyyy-MM-dd): ");
                    Date checkOut = sdf.parse(scanner.nextLine());
                    makeReservation(customerName, roomCategory, checkIn, checkOut);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Display available rooms by category
    static void displayAvailableRooms(String category) {
        System.out.println("Available Rooms in Category: " + category);
        boolean found = false;
        for (int i = 0; i < roomNumbers.length; i++) {
            if (roomAvailability[i] && roomCategories[i].equalsIgnoreCase(category)) {
                System.out.println("Room " + roomNumbers[i] + " - $" + roomPrices[i] + " per night");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available rooms in this category.");
        }
    }

    // Make a reservation
    static void makeReservation(String customerName, String category, Date checkIn, Date checkOut) {
        for (int i = 0; i < roomNumbers.length; i++) {
            if (roomAvailability[i] && roomCategories[i].equalsIgnoreCase(category)) {
                // Mark the room as booked
                roomAvailability[i] = false;
                bookingIds[bookingCounter] = bookingCounter + 1;
                customerNames[bookingCounter] = customerName;
                bookedRoomNumbers[bookingCounter] = roomNumbers[i];
                checkInDates[bookingCounter] = checkIn;
                checkOutDates[bookingCounter] = checkOut;

                // Calculate total price
                long numberOfNights = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
                double totalPrice = numberOfNights * roomPrices[i];
                bookingPayments[bookingCounter] = totalPrice;

                System.out.println("Reservation successful! Room " + roomNumbers[i] + " is booked.");
                System.out.println("Total price for " + numberOfNights + " nights: $" + totalPrice);

                bookingCounter++;
                return;
            }
        }
        System.out.println("No available rooms in the requested category.");
    }

    // View all bookings
    static void viewBookings() {
        System.out.println("All Bookings:");
        if (bookingCounter == 0) {
            System.out.println("No bookings available.");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < bookingCounter; i++) {
            System.out.println("Booking ID: " + bookingIds[i] +
                    ", Customer: " + customerNames[i] +
                    ", Room: " + bookedRoomNumbers[i] +
                    ", Check-In: " + sdf.format(checkInDates[i]) +
                    ", Check-Out: " + sdf.format(checkOutDates[i]) +
                    ", Total Payment: $" + bookingPayments[i]);
        }
    }
}
