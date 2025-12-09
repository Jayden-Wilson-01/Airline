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
                Utilities.writeString("Customer ID: " + customerID + " Does not exist.");
                break;
            }
        }
    }

    public void deleteCustomer()
    {
        String customerID = Utilities.readString("Enter customer ID: ");

        for (int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getCustomerID().equals(customerID))
            {
                //Set new values
                customers.remove(i);
            }
            else
            {
                Utilities.writeString("Customer ID: " + customerID + " Does not exist.");
                break;
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Booking Functions">
    //Add customer
    public void addBooking()
    {
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

    //View customer details
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
                Utilities.writeString("Booking ID: " + bookingID + " Does not exist.");
                break;
            }
        }
    }

    //Add customer
    public void updateBooking()
    {
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
                Utilities.writeString("Booking ID: " + bookingID + " Does not exist.");
                break;
            }
        }
    }

    public void deleteBooking()
    {
        String bookingID = Utilities.readString("Enter booking ID: ");

        for (int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getBookingID().equals(bookingID))
            {
                //Set new values
                bookings.remove(i);
            }
            else
            {
                Utilities.writeString("Booking ID: " + bookingID + " Does not exist.");
                break;
            }
        }
    }
    //</editor-fold>
}
