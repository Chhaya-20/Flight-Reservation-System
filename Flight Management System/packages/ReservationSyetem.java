package packages;
// Define the ReservationSystem class to manage flights and reservations

import java.util.HashMap;

class ReservationSystem {
    HashMap<Integer, Flight> flight = new HashMap<>();
    HashMap<Integer, Integer> reserve = new HashMap<>();

    // Method to add a flight
    public void addflight(Flight f) {
        try {
            Flight f1 = flight.get(f.getFlightNumber());
            if (f1 != null) {
                throw new ReservationException("Already Flight exist with this Flightno.....");
            }
            flight.put(f.getFlightNumber(), f);
            System.out.println("Flight Successfully Added.........");

        } catch (ReservationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured");
        }

    }

    // Method to reserve a seat on a flight
    public void reserveSeat(int aadhar, int flightno) {
        try {
            Flight f = flight.get(flightno);
            if (f == null) {
                throw new ReservationException("No Flight exist with this Flightno.....");
            }
            if (f.availableSeats <= 0) {
                throw new ReservationException("No Seats Available for This Flight.....");
            }
            f.availableSeats = f.availableSeats - 1;
            reserve.put(aadhar, flightno);
            System.out.println("Your Reservation for Flight no. ( " + flightno + " ) Is Syccessfully  Done.......");

        } catch (ReservationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured");
        }

    }

    // Method to display all flights
    public boolean showFlight() {
        if (flight.size() == 0) {
            System.out.println("No flight available.....");
            return false;
        }
        for (java.util.Map.Entry<Integer, Flight> it : flight.entrySet()) {
            System.out.println("Flight Details are => ");
            System.out.println("Flight Number = " + it.getValue().flightNumber + " , Departure City = "
                    + it.getValue().departureCity
                    + " , Landing City = " + it.getValue().destinationCity + " , Seats are = "
                    + it.getValue().availableSeats);

        }
        return true;
    }

    // Method to display reserved flights for a given Aadhar number
    public void showReserv(int aadhar) {
        try {
            if (!reserve.containsKey(aadhar)) {
                throw new ReservationException("You do not have any Reserve Flight......");
            }
            int n = reserve.get(aadhar);
            Flight f = flight.get(n);
            System.out.println("Your Reserve Flight Details are => ");
            System.out.println("Flight Number = " + f.getFlightNumber() + " , Departure City = " + f.getDepartureCity()
                    + " , Landing City = " + f.getDestinationCity());

        } catch (ReservationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some Error Occured.....");
        }

    }

    // Method to cancel a reservation for a given Aadhar number
    public void cancelSeat(int aadhar) {
        try {
            if (!reserve.containsKey(aadhar)) {
                throw new ReservationException("You have no reserve flight.....");
            }
            int f = reserve.get(aadhar);
            Flight f1 = flight.get(f);
            f1.availableSeats = f1.availableSeats + 1;
            reserve.remove(aadhar);
            System.out.println(" Your Cancellation for Your Flight Is Syccessfully  Done.......");

        } catch (ReservationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured");
        }

    }

}