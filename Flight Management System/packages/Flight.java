package packages;

//Flight Class
class Flight {
    int flightNumber; // A unique identifier for each flight.
    String departureCity; // The departure city for the flight.
    String destinationCity; // The destination city for the flight.
    int availableSeats; // The number of available seats on the flight.

    // Constructor to initialize Flight object
    public Flight(int flightNumber, String departureCity, String destinationCity, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;

        if (availableSeats >= 0) {
            this.availableSeats = availableSeats;
        }

        else {
            throw new IllegalArgumentException("Seat must be positive integers.");

        }
    }

    // Getter methods for Flight attributes
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

}
