package Code_Alpha_Tasks;
import java.util.Scanner;
public class Code_Alpha_Task_1 {
    static Scanner sc = new Scanner (System.in);
    static int totalSingleSharingRoom = 20;
    static int totalDoubleSharingRoom = 14;
    static int totalTripleSharingRoom = 10;
    static int priceForSingleSharingRoom = 2200;
    static int priceForDoubleSharingRoom = 2500;
    static int priceForTripleSharingRoom = 3000;
    static int reservationForSingleSharingRoom = 0;
    static int reservationForDoubleSharingRoom = 0;
    static int reservationForTripleSharingRoom = 0;
    static int numberOfRoom;
    static void menu(String userName){
        boolean running = true;
        while(running) {
            System.out.println("\nMain Menu");
            System.out.println("1.Search for Room Availability.");
            System.out.println("2.Make Reservation.");
            System.out.println("3.View Booking Detail.");
            System.out.println("4.Exit Menu");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter Your Choice.");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    searchForRoomAvailability(userName);
                    break;
                case 2:
                    makeReservation(userName);
                    break;
                case 3:
                    viewBookingDetail(userName);
                    running = false;
                    break;
                case 4:
                    System.out.println("Thanks for visiting!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    static void searchForRoomAvailability(String userName){
        System.out.println("Hello! " + userName + " "+ " Available Single Sharing Room  is :" +(totalSingleSharingRoom-reservationForSingleSharingRoom));
        System.out.println("Hello! " + userName + " "+ " Available Double Sharing Room  is:" +(totalDoubleSharingRoom-reservationForDoubleSharingRoom));
        System.out.println("Hello! " + userName + " "+ " Available  Triple Sharing Room is:" +(totalTripleSharingRoom-reservationForTripleSharingRoom));
        System.out.println("--------------------------------------------------------------");
    }
    static void makeReservation(String userName) {
        System.out.println("1.price for Single Sharing :($2200)");
        System.out.println("2.price for Single Sharing :($2500)");
        System.out.println("3.price for Single Sharing :($3000)");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                if (reservationForSingleSharingRoom < totalSingleSharingRoom) {
                    System.out.println("How many Single Sharing room do You Want to Book.");
                    numberOfRoom = sc.nextInt();
                    sc.nextLine();
                    confirmBooking("Single Sharing", priceForSingleSharingRoom);
                    if (numberOfRoom <= totalSingleSharingRoom - reservationForSingleSharingRoom) {
                        reservationForSingleSharingRoom += numberOfRoom;
                    } else {
                        System.out.println("Not enough rooms available. Please try again.");
                    }
                } else {
                    System.out.println("Sorry! Single Sharing Room is Full booked.");
                }
                break;
            case 2:
                if (reservationForDoubleSharingRoom < totalDoubleSharingRoom) {
                    System.out.println("How many Double Sharing room do You Want to Book.");
                    numberOfRoom = sc.nextInt();
                    sc.nextLine();
                    confirmBooking("Double Sharing", priceForDoubleSharingRoom);
                    if (numberOfRoom <= totalDoubleSharingRoom - reservationForDoubleSharingRoom) {
                        reservationForDoubleSharingRoom += numberOfRoom;
                    } else {
                        System.out.println("Not Enough room are available! please try again.");
                    }
                } else {
                    System.out.println("Sorry! Double Sharing Room is Full booked");
                }
                break;
            case 3:
                if (reservationForTripleSharingRoom < totalTripleSharingRoom) {
                    System.out.println("How many Triple Sharing room do You Want to Book.");
                    numberOfRoom = sc.nextInt();
                    sc.nextLine();
                    confirmBooking("Triple Sharing", priceForTripleSharingRoom);
                    if (numberOfRoom <= totalTripleSharingRoom - reservationForTripleSharingRoom) {
                        reservationForTripleSharingRoom += numberOfRoom;
                    } else {
                        System.out.println("Not Enough rooms are available.");
                    }
                } else {
                    System.out.println("Sorry! Double Sharing Room is Full booked");
                }

                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    static void confirmBooking(String roomType, int price){
        System.out.println(" Would You like to confirm Booking for(yes/no) for " +roomType);
        String answer = sc.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            System.out.println(" You confirmed " +roomType);
        }
        else if(answer.equalsIgnoreCase("no")){
            System.out.println("Booking Cancelled. Returning to Main Menu.");
        }
        else{
            System.out.println("Invalid choice!");
        }
    }
    static void viewBookingDetail(String userName){
        System.out.println(" \nBooking Detail for " +userName);
        System.out.println("---------------------------------------------------------------------");
         int totalPayment = ((reservationForSingleSharingRoom*priceForSingleSharingRoom) + (reservationForDoubleSharingRoom*priceForDoubleSharingRoom)
        + (reservationForTripleSharingRoom*priceForTripleSharingRoom));
        System.out.println("Your Booking Detail is.");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Reservation For Single Sharing :" +reservationForSingleSharingRoom );
        System.out.println("Reservation For Double Sharing :" +reservationForDoubleSharingRoom );
        System.out.println("Reservation For Triple Sharing :" +reservationForTripleSharingRoom );
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Total bill =" +totalPayment);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter your Good Name:");
        String userName = sc.nextLine();
        System.out.println( userName + " Welcome to our Hotel Reservation System.");
        System.out.println("-------------------------------------------------------------");
        menu(userName);
    }
}