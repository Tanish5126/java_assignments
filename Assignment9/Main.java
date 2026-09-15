import java.util.Scanner;
import cab.booking.CabBooking;
import cab.booking.CabBooking.CabType;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Smart Cab Booking System =====");
        System.out.println();

        // Input passenger details
        System.out.print("Enter Passenger ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Cab Type (MINI / SEDAN / SUV): ");
        String type = sc.nextLine().toUpperCase();

        System.out.print("Enter Base Fare: ₹");
        double fare = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Pickup Location: ");
        String location = sc.nextLine();

        // Enum
        CabType cabType = CabType.valueOf(type);

        // Autoboxing
        Integer passengerId = id;
        Double baseFare = fare;

        // Create booking object
        CabBooking booking = new CabBooking(
                passengerId,
                name,
                cabType,
                baseFare
        );

        System.out.println();

        // Display booking summary
        System.out.println(booking.getBookingSummary());

        // Inner Class
        CabBooking.PickupLocation pickup =
                booking.new PickupLocation(location);

        pickup.displayLocation();

        System.out.println();

        // Anonymous Class
        booking.confirmBooking();

        sc.close();
    }
}