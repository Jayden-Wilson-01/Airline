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

    //<editor-fold desc="Customer Functions">
    //Add customer
    public void addCustomer()
    {
        //Create empty customer
        Customer customer = new Customer();

        //Get values for customer
        String customerID = Utilities.readString("Enter customer ID: ");
        String customerFirstName = Utilities.readString("Enter customer name: ");
        String customerLastName = Utilities.readString("Enter customer last name: ");
        String customerEmail = Utilities.readString("Enter customer email: ");
        String customerPhone = Utilities.readString("Enter customer phone: ");
        String customerAddress = Utilities.readString("Enter customer address: ");

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
        String customerID = Utilities.readString("Enter customer ID: ");

        for (int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getCustomerID().equals(customerID))
            {
                Utilities.writeString("Customer ID: " + customers.get(i).getCustomerID());
                Utilities.writeString("Customer first name: " + customers.get(i).getFirstName());
                Utilities.writeString("Customer last name: " + customers.get(i).getLastName());
                Utilities.writeString("Customer email: " + customers.get(i).getEmail());
                Utilities.writeString("Customer phone number: " + customers.get(i).getPhone());
                Utilities.writeString("Customer address: " + customers.get(i).getAddress());

            }
            else
            {
                //Todo: Fix iteration error
                //Only checks the first item if the Customer ID is not the same then it doesn't continue.
                Utilities.writeString("Customer ID: " + customerID + " Does not exist.");
                break;
            }
        }
    }

    //Add customer
    public void updateCustomer()
    {
        //Get values for new customer
        String customerID = Utilities.readString("Enter existing customer ID: ");
        String customerFirstName = Utilities.readString("Enter new customer name: ");
        String customerLastName = Utilities.readString("Enter new customer last name: ");
        String customerEmail = Utilities.readString("Enter new customer email: ");
        String customerPhone = Utilities.readString("Enter new customer phone: ");
        String customerAddress = Utilities.readString("Enter new customer address: ");

        for (int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getCustomerID().equals(customerID))
            {
                //Set new values
                customers.get(i).setFirstName(customerFirstName);
                customers.get(i).setLastName(customerLastName);
                customers.get(i).setEmail(customerEmail);
                customers.get(i).setPhone(customerPhone);
                customers.get(i).setAddress(customerAddress);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Customer ID: " + customerID + " Does not exist.");
                break;
            }
        }
    }

    public void deleteCustomer()
    {
        //Todo: prevent customer being deleted unless referenced booking is deleted first

        String customerID = Utilities.readString("Enter customer ID: ");

        for (int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getCustomerID().equals(customerID))
            {
                //Delete from list
                customers.remove(i);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Customer ID: " + customerID + " Does not exist.");
                break;
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Booking Functions">
    //Add booking
    public void addBooking()
    {
        //Todo: check if foreign keys refer to existing entry

        //Create empty booking
        Booking booking = new Booking();

        //Get values for booking
        String bookingID = Utilities.readString("Enter booking ID: ");
        Date bookingDate = Utilities.readDate("Enter booking date: ");
        String customerID = Utilities.readString("Enter customer ID: ");
        String flightID = Utilities.readString("Enter flight ID: ");

        //Set values for the empty booking object
        booking.setBookingID(bookingID);
        booking.setBookingDate(bookingDate);
        booking.setCustomerID(customerID);
        booking.setFlightID(flightID);

        //Add booking to list
        bookings.add(booking);
    }

    //View booking details
    public void viewBooking()
    {
        String bookingID = Utilities.readString("Enter booking ID: ");

        for (int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getBookingID().equals(bookingID))
            {
                Utilities.writeString("Booking ID: " + bookings.get(i).getBookingID());
                Utilities.writeString("Booking date: " + bookings.get(i).getBookingDate());
                Utilities.writeString("Booking flight ID: " + bookings.get(i).getFlightID());
                Utilities.writeString("Booking customer ID: " + bookings.get(i).getCustomerID());
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Booking ID: " + bookingID + " Does not exist.");
                break;
            }
        }
    }

    //Update booking
    public void updateBooking()
    {
        //Todo: check if foreign keys refer to existing entry

        //Get values for new booking
        String bookingID = Utilities.readString("Enter existing booking ID: ");
        Date bookingDate = Utilities.readDate("Enter booking date: ");
        String customerID = Utilities.readString("Enter new customer ID: ");
        String flightID = Utilities.readString("Enter new flight ID: ");

        for (int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getBookingID().equals(bookingID))
            {
                //Set new values
                bookings.get(i).setBookingDate(bookingDate);
                bookings.get(i).setCustomerID(customerID);
                bookings.get(i).setFlightID(flightID);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Booking ID: " + bookingID + " Does not exist.");
                break;
            }
        }
    }

    //Delete booking
    public void deleteBooking()
    {
        String bookingID = Utilities.readString("Enter booking ID: ");

        for (int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getBookingID().equals(bookingID))
            {
                //Delete from list
                bookings.remove(i);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Booking ID: " + bookingID + " Does not exist.");
                break;
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Flight Functions">
    //Add flight
    public void addflight()
    {
        //Create empty flight
        Flight flight = new Flight();

        //Get values for flight
        String flightID = Utilities.readString("Enter flight ID: ");
        String flightNumber = Utilities.readString("Enter flight number: ");
        String departureAirport = Utilities.readString("Enter departure airport: ");
        String arrivalAirport = Utilities.readString("Enter arrival airport: ");
        Date getDepartureDateTime = Utilities.readDate("Enter departure date: ");
        Date getArrivalDepartureDateTime = Utilities.readDate("Enter arrival date: ");

        //Set values for the empty flight object
        flight.setFlightID(flightID);
        flight.setFlightNumber(flightNumber);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureDateTime(getDepartureDateTime);
        flight.setArrivalDateTime(getArrivalDepartureDateTime);

        //Add flight to list
        flights.add(flight);
    }

    //View flight details
    public void viewFlight()
    {
        String flightID = Utilities.readString("Enter flight ID: ");

        for (int i = 0; i < flights.size(); i++)
        {
            if(flights.get(i).getFlightID().equals(flightID))
            {
                Utilities.writeString("Flight ID: " + flights.get(i).getFlightID());
                Utilities.writeString("Flight number: " + flights.get(i).getFlightNumber());
                Utilities.writeString("Departure Airport: " + flights.get(i).getDepartureAirport());
                Utilities.writeString("Arrival Airport: " + flights.get(i).getArrivalAirport());
                Utilities.writeString("Departure Date: " + flights.get(i).getDepartureDateTime());
                Utilities.writeString("Arrival Date: " + flights.get(i).getArrivalDateTime());
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("flight ID: " + flightID + " Does not exist.");
                break;
            }
        }
    }

    //Update flight
    public void updateFlight()
    {
        //Get values for new booking
        String flightID = Utilities.readString("Enter existing flight ID: ");
        String flightNumber = Utilities.readString("Enter flight number: ");
        String departureAirport = Utilities.readString("Enter departure airport: ");
        String arrivalAirport = Utilities.readString("Enter arrival airport: ");
        Date getDepartureDateTime = Utilities.readDate("Enter departure date: ");
        Date getArrivalDepartureDateTime = Utilities.readDate("Enter arrival date: ");

        for (int i = 0; i < flights.size(); i++)
        {
            if(flights.get(i).getFlightID().equals(flightID))
            {
                //Set new values
                flights.get(i).setFlightNumber(flightNumber);
                flights.get(i).setDepartureAirport(departureAirport);
                flights.get(i).setArrivalAirport(arrivalAirport);
                flights.get(i).setDepartureDateTime(getDepartureDateTime);
                flights.get(i).setArrivalDateTime(getArrivalDepartureDateTime);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Flight ID: " + flightID + " Does not exist.");
                break;
            }
        }
    }

    //Delete flight
    public void deleteFlight()
    {
        //Todo: prevent flight being deleted unless referenced booking is deleted first

        String flightID = Utilities.readString("Enter flight ID: ");

        for (int i = 0; i < flights.size(); i++)
        {
            if(flights.get(i).getFlightID().equals(flightID))
            {
                //Delete from list
                flights.remove(i);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Flight ID: " + flightID + " Does not exist.");
                break;
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Route Functions">
    //Add route
    public void addRoute()
    {
        //Create empty route
        Route route = new Route();

        //Get values for route
        String routeID = Utilities.readString("Enter route ID: ");
        String routeName = Utilities.readString("Enter route name: ");

        //Set values for the empty route object
        route.setRouteID(routeID);
        route.setRouteName(routeName);

        //Add route to list
        routes.add(route);
    }

    //View route details
    public void viewRoute()
    {
        String routeID = Utilities.readString("Enter route ID: ");

        for (int i = 0; i < routes.size(); i++)
        {
            if(routes.get(i).getRouteID().equals(routeID))
            {
                Utilities.writeString("Route ID: " + routes.get(i).getRouteID());
                Utilities.writeString("Route Name: " + routes.get(i).getRouteName());
            }
            else
            {
                Utilities.writeString("Route ID: " + routeID + " Does not exist.");
                break;
            }
        }
    }

    //Update route
    public void updateRoute()
    {
        //Get values for new route
        String routeID = Utilities.readString("Enter existing route ID: ");
        String routeName = Utilities.readString("Enter route name: ");

        for (int i = 0; i < routes.size(); i++)
        {
            if(routes.get(i).getRouteID().equals(routeID))
            {
                //Set new values
                routes.get(i).setRouteName(routeName);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Route ID: " + routeID + " Does not exist.");
                break;
            }
        }
    }

    //Delete route
    public void deleteRoute()
    {
        String routeID = Utilities.readString("Enter route ID: ");

        for (int i = 0; i < routes.size(); i++)
        {
            if(routes.get(i).getRouteID().equals(routeID))
            {
                //Delete from list
                routes.remove(i);
            }
            else
            {
                //Todo: Fix iteration error
                Utilities.writeString("Route ID: " + routeID + " Does not exist.");
                break;
            }
        }
    }
    //</editor-fold>
}
