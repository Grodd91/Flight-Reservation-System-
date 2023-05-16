import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

class Flight {

    private String flightNumber;

    private String source;

    private String destination;

    private int seatsAvailable;

    private double price;

    public Flight(String flightNumber, String source, String destination, int seatsAvailable, double price) {

        this.flightNumber = flightNumber;

        this.source = source;

        this.destination = destination;

        this.seatsAvailable = seatsAvailable;

        this.price = price;

    }

    public String getFlightNumber() {

        return flightNumber;

    }

    public String getSource() {

        return source;

    }

    public String getDestination() {

        return destination;

    }

    public int getSeatsAvailable() {

        return seatsAvailable;

    }

    public double getPrice() {

        return price;

    }

    public void bookTicket() {

        if (seatsAvailable > 0) {

            seatsAvailable--;

            System.out.println("Ticket booked successfully!");

        } else {

            System.out.println("Sorry, no seats available for this flight.");

        }

    }

}

class FlightReservationSystem {

    private List<Flight> flights;

    public FlightReservationSystem() {

        flights = new ArrayList<>();

    }

    public void addFlight(Flight flight) {

        flights.add(flight);

    }

    public Flight findFlight(String flightNumber) {

        for (Flight flight : flights) {

            if (flight.getFlightNumber().equals(flightNumber)) {

                return flight;

            }

        }

        return null;

    }

    public void displayFlights() {

        for (Flight flight : flights) {

            System.out.println("Flight Number: " + flight.getFlightNumber());

            System.out.println("Source: " + flight.getSource());

            System.out.println("Destination: " + flight.getDestination());

            System.out.println("Seats Available: " + flight.getSeatsAvailable());

            System.out.println("Price: $" + flight.getPrice());

            System.out.println("-----------------------------");

        }

    }

}

public class FlightReservationApp {

    public static void main(String[] args) {

        FlightReservationSystem reservationSystem = new FlightReservationSystem();

        // Add some sample flights

        reservationSystem.addFlight(new Flight("ABC123", "New York", "Los Angeles", 100, 250.0));

        reservationSystem.addFlight(new Flight("DEF456", "London", "Paris", 50, 150.0));

        reservationSystem.addFlight(new Flight("GHI789", "Tokyo", "Sydney", 200, 350.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to Flight Reservation System");

            System.out.println("1. View available flights");

            System.out.println("2. Book a ticket");

            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    reservationSystem.displayFlights();

                    break;

                case 2:

                    System.out.print("Enter flight number: ");

                    String flightNumber = scanner.next();

                    Flight flight = reservationSystem.findFlight(flightNumber);

                    if (flight != null) {

                        flight.bookTicket();

                    } else {

                        System.out.println("Flight not found.");

                    }

                    break;

                case 3:

                    System.out.println("Thank you for using Flight Reservation System. Goodbye!");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice. Please select the correct option.");

                            }

    }

}

}
