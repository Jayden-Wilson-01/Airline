package Data;

import Models.Booking;
import Models.Customer;
import Models.Flight;
import Models.Route;
import Utilities.Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter
{
    public static void writeCustomersToCsv(List<Customer> customers, String filePath)
    {
        try (FileWriter writer = new FileWriter(filePath)) {

            // Write CSV headings
            writer.write("CustomerID,FirstName,LastName,Email,Phone,Address\n");

            // Write each customer row
            for (int i = 0; i < customers.size(); i++)
            {
                Customer customer = customers.get(i);

                //Append details
                writer.write(customer.getCustomerID() + ",");
                writer.write(customer.getFirstName() + ",");
                writer.write(customer.getLastName() + ",");
                writer.write(customer.getEmail() + ",");
                writer.write(customer.getPhone() + ",");
                writer.write(customer.getAddress() + "\n");
            }

            writer.flush();
            System.out.println("CSV file created at: " + filePath);

        }
        catch (Exception e)
        {
            Utilities.writeString(e.getMessage());
        }
    }

    public static void writeFlightsToCsv(List<Flight> flights, String filePath)
    {
        try (FileWriter writer = new FileWriter(filePath)) {

            // Write CSV headings
            writer.write("FlightID,FlightNumber,DepartureAirport,ArrivalAirport,DepartureDateTime,ArrivalDateTime\n");

            // Write each flight row
            for (int i = 0; i < flights.size(); i++)
            {
                Flight flight = flights.get(i);

                //Append details
                writer.write(flight.getFlightID() + ",");
                writer.write(flight.getFlightNumber() + ",");
                writer.write(flight.getDepartureAirport() + ",");
                writer.write(flight.getArrivalAirport() + ",");
                writer.write(flight.getDepartureDateTime().toString() + ",");
                writer.write(flight.getArrivalDateTime().toString() + "\n");
            }

            writer.flush();
            System.out.println("CSV file created at: " + filePath);

        }
        catch (Exception e)
        {
            Utilities.writeString(e.getMessage());
        }
    }

    public static void writeBookingsToCsv(List<Booking> bookings, String filePath)
    {
        try (FileWriter writer = new FileWriter(filePath)) {

            // Write CSV headings
            writer.write("BookingID,BookingDate,CustomerID,FlightID\n");

            // Write each booking row
            for (int i = 0; i < bookings.size(); i++)
            {
                Booking booking = bookings.get(i);

                //Append details
                writer.write(booking.getBookingID() + ",");
                writer.write(booking.getBookingDate().toString() + ","); // no formatting
                writer.write(booking.getCustomerID() + ",");
                writer.write(booking.getFlightID() + "\n");
            }

            writer.flush();
            System.out.println("CSV file created at: " + filePath);

        }
        catch (Exception e)
        {
            Utilities.writeString(e.getMessage());
        }
    }

    public static void writeRoutesToCsv(List<Route> routes, String filePath)
    {
        try (FileWriter writer = new FileWriter(filePath)) {

            // Write CSV headings
            writer.write("RouteID,RouteName\n");

            // Write each route row
            for (int i = 0; i < routes.size(); i++)
            {
                Route route = routes.get(i);

                //Append details
                writer.write(route.getRouteID() + ",");
                writer.write(route.getRouteName() + "\n");
            }

            writer.flush();
            System.out.println("CSV file created at: " + filePath);

        }
        catch (Exception e)
        {
            Utilities.writeString(e.getMessage());
        }
    }
}
