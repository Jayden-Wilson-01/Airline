package Data;

import Models.Booking;
import Models.Customer;
import Models.Flight;
import Models.Route;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemManager
{
    List<Customer> customers = new ArrayList<Customer>();
    List<Booking> bookings = new ArrayList<Booking>();
    List<Flight> flights = new ArrayList<Flight>();
    List<Route> routes = new ArrayList<Route>();

    //Check if customer id exists
    private Customer checkCustomerExists(String customerId)
    {
        for (int i = 0; i < customers.size(); i++)
        {
            if (customers.get(i).getCustomerID().equals(customerId))
            {
                return customers.get(i);  // match found
            }
        }

        return null; // no match
    }

    //Check if booking id exists
    private Booking checkBookingExists(String bookingId)
    {
        for (int i = 0; i < bookings.size(); i++)
        {
            if (bookings.get(i).getBookingID().equals(bookingId))
            {
                return bookings.get(i);  // match found
            }
        }

        return null; // no match
    }

    //Check if flight id exists
    private Flight checkFlightExists(String flightId)
    {
        for (int i = 0; i < flights.size(); i++)
        {
            if (flights.get(i).getFlightID().equals(flightId))
            {
                return flights.get(i);  // match found
            }
        }

        return null; // no match
    }

    //Check if route id exists
    private Route checkRouteExists(String routeId)
    {
        for (int i = 0; i < routes.size(); i++)
        {
            if (routes.get(i).getRouteID().equals(routeId))
            {
                return routes.get(i);  // match found
            }
        }

        return null; // no match
    }

    //<editor-fold desc="Customer Functions">
    //Customer list to CSV
    public void customersToCSV()
    {
        CsvExporter.writeCustomersToCsv(customers, "customers.csv");
    }

    //Add customer
    public void addCustomer()
    {
        //Get customer id
        String customerID;

        do
        {
            customerID = Utilities.readString("Enter customer id: ");
        }
        while(checkCustomerExists(customerID) != null); //if it exists keep asking for id

        //Get rest of the details
        String customerFirstName = Utilities.readString("Enter customer name: ");
        String customerLastName = Utilities.readString("Enter customer last name: ");
        String customerEmail = Utilities.readString("Enter customer email: ");
        String customerPhone = Utilities.readString("Enter customer phone: ");
        String customerAddress = Utilities.readString("Enter customer address: ");

        //Create customer
        Customer customer = new Customer();

        //Set values for the empty customer object
        customer.setCustomerID(customerID);
        customer.setFirstName(customerFirstName);
        customer.setLastName(customerLastName);
        customer.setEmail(customerEmail);
        customer.setPhone(customerPhone);
        customer.setAddress(customerAddress);

        //Add customer to list
        customers.add(customer);
    }

    //View customer details
    public void viewCustomer()
    {
        //Get customer id
        String customerID;
        Customer customer;

        do
        {
            customerID = Utilities.readString("Enter customer id, 0 to cancel: ");
            customer = checkCustomerExists(customerID);

            if(customerID.equals("0"))
            {
                return;
            }
        }
        while(customer == null); //if it doesn't exist keep asking for id

        //Display customer details
        Utilities.writeString("Customer ID: " + customer.getCustomerID());
        Utilities.writeString("Customer first name: " + customer.getFirstName());
        Utilities.writeString("Customer last name: " + customer.getLastName());
        Utilities.writeString("Customer email: " + customer.getEmail());
        Utilities.writeString("Customer phone number: " + customer.getPhone());
        Utilities.writeString("Customer address: " + customer.getAddress());
    }

    //Add customer
    public void updateCustomer()
    {
        //Get customer id
        String customerID;
        Customer customer;

        do
        {
            customerID = Utilities.readString("Enter customer id, 0 to cancel: ");
            customer = checkCustomerExists(customerID);

            if(customerID.equals("0"))
            {
                return;
            }
        }
        while(customer == null); //if it doesn't exist keep asking for id

        //Get values for new customer
        String customerFirstName = Utilities.readString("Enter new customer name: ");
        String customerLastName = Utilities.readString("Enter new customer last name: ");
        String customerEmail = Utilities.readString("Enter new customer email: ");
        String customerPhone = Utilities.readString("Enter new customer phone: ");
        String customerAddress = Utilities.readString("Enter new customer address: ");

        customer.setFirstName(customerFirstName);
        customer.setLastName(customerLastName);
        customer.setEmail(customerEmail);
        customer.setPhone(customerPhone);
        customer.setAddress(customerAddress);
    }

    public void deleteCustomer()
    {
        //Get customer id
        String customerID;
        Customer customer;

        do
        {
            customerID = Utilities.readString("Enter customer id, 0 to cancel: ");
            customer = checkCustomerExists(customerID);

            if(customerID.equals("0"))
            {
                return;
            }
        }
        while(customer == null); //if it doesn't exist keep asking for id

        customers.remove(customer);
    }
    //</editor-fold>

    //<editor-fold desc="Booking Functions">
    //Bookings list to CSV
    public void bookingsToCSV()
    {
        CsvExporter.writeBookingsToCsv(bookings, "bookings.csv");
    }

    //Add booking
    public void addBooking()
    {
        //Get booking id
        String bookingID;
        do
        {
            bookingID = Utilities.readString("Enter new booking id: ");
        }
        while(checkBookingExists(bookingID) != null); //if it exists keep asking for id

        //Get customer id
        String customerID;
        Customer customer;
        do
        {
            customerID = Utilities.readString("Enter customer id, 0 to cancel: ");
            customer = checkCustomerExists(customerID);

            if(customerID.equals("0"))
            {
                return;
            }
        }
        while(customer == null); //if it doesn't exist keep asking for id

        //Get flight id
        String flightId;
        Flight flight;
        do
        {
            flightId = Utilities.readString("Enter flight id, 0 to cancel: ");
            flight = checkFlightExists(flightId);

            if(flightId.equals("0"))
            {
                return;
            }
        }
        while(flight == null); //if it doesn't exist keep asking for id

        Booking booking = new Booking();
        booking.setBookingID(bookingID);
        booking.setCustomerID(customer.getCustomerID());
        booking.setFlightID(flight.getFlightID());
        booking.setBookingDate(Utilities.readDate("Enter booking date: "));
        bookings.add(booking);

    }

    //View booking details
    public void viewBooking()
    {
        //Get booking id
        String bookingId;
        Booking booking;

        do
        {
            bookingId = Utilities.readString("Enter booking id, 0 to cancel: ");
            booking = checkBookingExists(bookingId);

            if(bookingId.equals("0"))
            {
                return;
            }
        }
        while(booking == null); //if it doesn't exist keep asking for id

        //Display customer details
        Utilities.writeString("Booking ID: " + booking.getBookingID());
        Utilities.writeString("Customer ID: " + booking.getCustomerID());
        Utilities.writeString("Flight ID: " + booking.getFlightID());
        Utilities.writeString("]Booking Date: " + booking.getBookingDate());
    }

    //Update booking
    public void updateBooking()
    {
        //Get booking id
        String bookingID;
        Booking booking;
        do
        {
            bookingID = Utilities.readString("Enter booking id, 0 to cancel: ");
            booking = checkBookingExists(bookingID);

            if(bookingID.equals("0"))
            {
                return;
            }
        }
        while(booking == null); //if it doesn't exist keep asking for id

        //Get customer id
        String customerID;
        Customer customer;
        do
        {
            customerID = Utilities.readString("Enter customer id, 0 to cancel: ");
            customer = checkCustomerExists(customerID);

            if(customerID.equals("0"))
            {
                return;
            }
        }
        while(customer == null); //if it doesn't exist keep asking for id

        //Get flight id
        String flightId;
        Flight flight;
        do
        {
            flightId = Utilities.readString("Enter flight id, 0 to cancel: ");
            flight = checkFlightExists(flightId);

            if(flightId.equals("0"))
            {
                return;
            }
        }
        while(flight == null); //if it doesn't exist keep asking for id

        booking.setBookingDate(Utilities.readDate("Enter booking date: "));

        booking.setBookingID(bookingID);
        booking.setCustomerID(customer.getCustomerID());
        booking.setFlightID(flight.getFlightID());
    }

    //Delete booking
    public void deleteBooking()
    {
        //Get booking id
        String bookingID;
        Booking booking;
        do
        {
            bookingID = Utilities.readString("Enter booking id, 0 to cancel: ");
            booking = checkBookingExists(bookingID);

            if(bookingID.equals("0"))
            {
                return;
            }
        }
        while(booking == null); //if it doesn't exist keep asking for id

        bookings.remove(booking);
    }
    //</editor-fold>

    //<editor-fold desc="Flight Functions">
    //Flights list to CSV
    public void flightsToCSV()
    {
        CsvExporter.writeFlightsToCsv(flights, "flights.csv");
    }

    //Add flight
    public void addflight()
    {
        //Get flight id
        String flightID;

        do
        {
            flightID = Utilities.readString("Enter flight id: ");
        }
        while(checkFlightExists(flightID) != null); //if it exists keep asking for id

        //Get values for flight
        String flightNumber = Utilities.readString("Enter flight number: ");
        String departureAirport = Utilities.readString("Enter departure airport: ");
        String arrivalAirport = Utilities.readString("Enter arrival airport: ");
        Date departureDateTime = Utilities.readDate("Enter departure date: ");
        Date arrivalDateTime;

        do
        {
            arrivalDateTime = Utilities.readDate("Enter arrival date that's on or after departure date: ");
        }
        while(arrivalDateTime.before(departureDateTime));

        //Set values for the empty flight object
        Flight flight = new Flight();
        flight.setFlightID(flightID);
        flight.setFlightNumber(flightNumber);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureDateTime(departureDateTime);
        flight.setArrivalDateTime(arrivalDateTime);

        //Add flight to list
        flights.add(flight);
    }

    //View flight details
    public void viewFlight()
    {
        //Get flight id
        String flightID;
        Flight flight;

        do
        {
            flightID = Utilities.readString("Enter flight id, 0 to cancel: ");
            flight = checkFlightExists(flightID);

            if(flightID.equals("0"))
            {
                return;
            }
        }
        while(flight == null); //if it doesn't exist keep asking for id

        Utilities.writeString("Flight ID: " + flight.getFlightID());
        Utilities.writeString("Flight number: " + flight.getFlightNumber());
        Utilities.writeString("Departure Airport: " + flight.getDepartureAirport());
        Utilities.writeString("Arrival Airport: " + flight.getArrivalAirport());
        Utilities.writeString("Departure Date: " + flight.getDepartureDateTime());
        Utilities.writeString("Arrival Date: " + flight.getArrivalDateTime());
    }

    //Update flight
    public void updateFlight()
    {
        //Get flight id
        String flightID;
        Flight flight;

        do
        {
            flightID = Utilities.readString("Enter flight id, 0 to cancel: ");
            flight = checkFlightExists(flightID);

            if(flightID.equals("0"))
            {
                return;
            }
        }
        while(flight == null); //if it doesn't exist keep asking for id


        //Get values for new booking
        String flightNumber = Utilities.readString("Enter flight number: ");
        String departureAirport = Utilities.readString("Enter departure airport: ");
        String arrivalAirport = Utilities.readString("Enter arrival airport: ");
        Date departureDateTime = Utilities.readDate("Enter departure date: ");
        Date arrivalDateTime;

        do
        {
            arrivalDateTime = Utilities.readDate("Enter arrival date that's on or after departure date:  ");
        }
        while(arrivalDateTime.before(departureDateTime));

        //Set new values
        flight.setFlightNumber(flightNumber);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureDateTime(departureDateTime);
        flight.setArrivalDateTime(arrivalDateTime);
    }

    //Delete flight
    public void deleteFlight()
    {
        //Get flight id
        String flightID;
        Flight flight;

        do
        {
            flightID = Utilities.readString("Enter flight id, 0 to cancel: ");
            flight = checkFlightExists(flightID);

            if(flightID.equals("0"))
            {
                return;
            }
        }
        while(flight == null); //if it doesn't exist keep asking for id

       flights.remove(flight);
    }
    //</editor-fold>

    //<editor-fold desc="Route Functions">
    //Route list to CSV
    public void routeToCSV()
    {
        CsvExporter.writeRoutesToCsv(routes, "route.csv");
    }

    //Add route
    public void addRoute()
    {
        //Get route id
        String routeId;

        do
        {
            routeId = Utilities.readString("Enter route id: ");
        }
        while(checkRouteExists(routeId) != null); //if it exists keep asking for id

        //Get values for route
        String routeName = Utilities.readString("Enter route name: ");

        //Set values for the empty route object
        Route route = new Route();
        route.setRouteID(routeId);
        route.setRouteName(routeName);

        //Add route to list
        routes.add(route);
    }

    //View route details
    public void viewRoute()
    {
        //Get route id
        String routeID;
        Route route;

        do
        {
            routeID = Utilities.readString("Enter route id, 0 to cancel: ");
            route = checkRouteExists(routeID);

            if(routeID.equals("0"))
            {
                return;
            }
        }
        while(route == null); //if it doesn't exist keep asking for id

        Utilities.writeString("Route ID: " + route.getRouteID());
        Utilities.writeString("Route Name: " + route.getRouteName());
    }

    //Update route
    public void updateRoute()
    {
        //Get route id
        String routeID;
        Route route;

        do
        {
            routeID = Utilities.readString("Enter route id, 0 to cancel: ");
            route = checkRouteExists(routeID);

            if(routeID.equals("0"))
            {
                return;
            }
        }
        while(route == null); //if it doesn't exist keep asking for id

        //Get values for new route
        String routeName = Utilities.readString("Enter route name: ");

        route.setRouteName(routeName);
    }

    //Delete route
    public void deleteRoute()
    {
        //Get route id
        String routeID;
        Route route;

        do
        {
            routeID = Utilities.readString("Enter route id, 0 to cancel: ");
            route = checkRouteExists(routeID);

            if(routeID.equals("0"))
            {
                return;
            }
        }
        while(route == null); //if it doesn't exist keep asking for id

        routes.remove(route);
    }
    //</editor-fold>
}
