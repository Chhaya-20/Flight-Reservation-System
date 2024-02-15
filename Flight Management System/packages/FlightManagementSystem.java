package packages;

import java.util.Scanner;

//import ReservationSystem;

// Define a custom exception for flight reservations

class FlightManagementSystem {
    public static void main(String[] args) {
        ReservationSystem r = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println(
                    "***************************************Welcome To Flight Management System **************************************");
            System.out.println("1. Add Flight");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Show Reserved Flights");
            System.out.println("5. Show All Flights");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Flight
                    System.out.println("Enter Flight Number:");
                    int flightNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Departure City:");
                    String departureCity = scanner.nextLine();
                    System.out.println("Enter Destination City:");
                    String destinationCity = scanner.nextLine();
                    System.out.println("Enter Available Seats:");
                    int availableSeats = scanner.nextInt();
                    Flight flight = new Flight(flightNumber, departureCity, destinationCity, availableSeats);
                    r.addflight(flight);
                    break;
                case 2:
                    // Reserve Seat
                    if (r.showFlight()) {
                        System.out.println("Enter Aadhar Number:");
                        int aadhar = scanner.nextInt();
                        System.out.println("Enter Flight Number to Reserve Seat:");
                        int flightToReserve = scanner.nextInt();
                        r.reserveSeat(aadhar, flightToReserve);
                    }

                    break;
                case 3:
                    // Cancel Reservation
                    System.out.println("Enter Aadhar Number to Cancel Reservation:");
                    int aadharToCancel = scanner.nextInt();
                    r.cancelSeat(aadharToCancel);
                    break;
                case 4:
                    // Show Reserved Flights
                    System.out.println("Enter Aadhar Number to Show Reserved Flights:");
                    int aadharToShow = scanner.nextInt();
                    r.showReserv(aadharToShow);
                    break;
                case 5:
                    // Show All Flights
                    r.showFlight();
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting Flight Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}