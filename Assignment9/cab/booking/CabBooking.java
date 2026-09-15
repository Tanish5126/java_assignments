package cab.booking;

public class CabBooking {

    // Enum for cab types
    public enum CabType {
        MINI,
        SEDAN,
        SUV
    }

    // Final booking fee
    private final Double bookingFee = 50.0;

    // Wrapper classes
    private Integer passengerId;
    private String passengerName;
    private CabType cabType;
    private Double baseFare;

    // Constructor
    public CabBooking(Integer passengerId, String passengerName,
                      CabType cabType, Double baseFare) {

        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.cabType = cabType;
        this.baseFare = baseFare;
    }

    // Inner Class for pickup location
    public class PickupLocation {

        private String location;

        public PickupLocation(String location) {
            this.location = location;
        }

        public void displayLocation() {
            System.out.println("Pickup Location: " + location);
        }
    }

    // Create booking summary
    public String getBookingSummary() {

        // Unboxing
        double fare = baseFare;
        double fee = bookingFee;

        double finalFare = fare + fee;

        // StringBuilder
        StringBuilder summary = new StringBuilder();

        summary.append("===== Smart Cab Booking System =====\n\n");
        summary.append("Passenger Name: ").append(passengerName).append("\n");
        summary.append("Cab Type: ").append(cabType).append("\n");
        summary.append("Base Fare: ₹").append(String.format("%.0f", fare)).append("\n");
        summary.append("Booking Fee: ₹").append(String.format("%.0f", fee)).append("\n");
        summary.append("Final Fare: ₹").append(String.format("%.0f", finalFare)).append("\n");

        return summary.toString();
    }

    // Anonymous Class
    public void confirmBooking() {

        BookingConfirmation confirmation = new BookingConfirmation() {

            @Override
            public void showMessage() {
                System.out.println("Booking confirmed successfully.");
            }
        };

        confirmation.showMessage();
    }

    // Interface for Anonymous Class
    interface BookingConfirmation {
        void showMessage();
    }
}