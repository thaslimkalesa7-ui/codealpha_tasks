import java.util.*;
import java.io.*;

class Room {
    int roomNo;
    String type;
    int price;

    Room(int roomNo, String type, int price) {
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
    }
}

public class Hotel_reservation_system {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<String> bookings = new ArrayList<>();

    static void searchRooms() {
        System.out.println("1. Standard - Rs.1000");
        System.out.println("2. Deluxe - Rs.2000");
        System.out.println("3. Suite - Rs.3000");

        System.out.print("Choose room type: ");
        int choice = sc.nextInt();

        String type = "";
        if (choice == 1) type = "Standard";
        else if (choice == 2) type = "Deluxe";
        else if (choice == 3) type = "Suite";
        else {
            System.out.println("Invalid choice!");
            return;
        }

        for (Room r : rooms) {
            boolean booked = false;

            for (String b : bookings) {
                if (b.contains("Room: " + r.roomNo + ","))
                    booked = true;
            }

            if (r.type.equals(type) && !booked) {
                System.out.println("Room: " + r.roomNo);
            }
        }
    }

    static void bookRoom() {
        searchRooms();

        System.out.print("Enter room number: ");
        int no = sc.nextInt();

        Room selected = null;

        for (Room r : rooms) {
            if (r.roomNo == no) {
                selected = r;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Invalid room!");
            return;
        }

        for (String b : bookings) {
            if (b.contains("Room: " + no + ",")) {
                System.out.println("Room already booked!");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        if (days <= 0) {
            System.out.println("Invalid days!");
            return;
        }

        int total = selected.price * days;

        System.out.println("Total Amount: Rs." + total);
        System.out.println("1. Pay");
        System.out.println("2. Cancel");

        int pay = sc.nextInt();

        if (pay == 1) {
            String data = "Room: " + no +
                    ", Name: " + name +
                    ", Days: " + days +
                    ", Amount: " + total;

            bookings.add(data);

            try {
                FileWriter fw = new FileWriter("bookings.txt");
                for (String b : bookings) {
                    fw.write(b + "\n");
                }
                fw.close();
            } catch (Exception e) {
                System.out.println("File error!");
            }

            System.out.println("Booking Successful!");
        } else {
            System.out.println("Booking Cancelled!");
        }
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found!");
            return;
        }

        for (String b : bookings) {
            System.out.println(b);
        }
    }

    static void cancelBooking() {
        System.out.print("Enter room number: ");
        int no = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).contains("Room: " + no + ",")) {
                bookings.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            try {
                FileWriter fw = new FileWriter("bookings.txt");
                for (String b : bookings) {
                    fw.write(b + "\n");
                }
                fw.close();
            } catch (Exception e) {
                System.out.println("File error!");
            }

            System.out.println("Booking Cancelled!");
        } else {
            System.out.println("Booking Not Found!");
        }
    }

    public static void main(String[] args) {

        rooms.add(new Room(101, "Standard", 1000));
        rooms.add(new Room(102, "Standard", 1000));
        rooms.add(new Room(201, "Deluxe", 2000));
        rooms.add(new Room(202, "Deluxe", 2000));
        rooms.add(new Room(301, "Suite", 3000));

        while (true) {
            System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}