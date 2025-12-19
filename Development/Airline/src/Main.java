import Data.SystemManager;
import Utilities.Utilities;

public class Main
{
    public static void main(String[] args)
    {
        SystemManager systemManager = new SystemManager();

        int option;

        while (true)
        {
            Utilities.writeString("Welcome to the flight manager");
            Utilities.writeString("Enter an option of your choosing:\n");
            Utilities.writeString("0. Exit");
            Utilities.writeString("");
            Utilities.writeString("1: Add a customer");
            Utilities.writeString("2: View customer");
            Utilities.writeString("3: Update customer");
            Utilities.writeString("4: Delete customer");
            Utilities.writeString("");
            Utilities.writeString("5: Add a flight");
            Utilities.writeString("6: View flight");
            Utilities.writeString("7: Update flight");
            Utilities.writeString("8: Delete flight");
            Utilities.writeString("");
            Utilities.writeString("9. Add a booking");
            Utilities.writeString("10: View booking");
            Utilities.writeString("11. Update booking");
            Utilities.writeString("12. Delete booking");
            Utilities.writeString("");
            Utilities.writeString("13. Add a route");
            Utilities.writeString("14. View route");
            Utilities.writeString("15. Update route");
            Utilities.writeString("16. Delete route");
            Utilities.writeString("");
            Utilities.writeString("17. Flights to CSV");
            Utilities.writeString("18. Customers to CSV");
            Utilities.writeString("19. Bookings to CSV");
            Utilities.writeString("20. Routes to CSV");

            option = Utilities.readInt("Enter option: ");

            switch (option)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    systemManager.addCustomer();
                    break;
                case 2:
                    systemManager.viewCustomer();
                    break;
                case 3:
                    systemManager.updateCustomer();
                    break;
                case 4:
                    systemManager.deleteCustomer();
                    break;
                case 5:
                    systemManager.addflight();
                    break;
                case 6:
                    systemManager.viewFlight();
                    break;
                case 7:
                    systemManager.updateFlight();
                    break;
                case 8:
                    systemManager.deleteFlight();
                    break;
                case 9:
                    systemManager.addBooking();
                    break;
                case 10:
                    systemManager.viewBooking();
                    break;
                case 11:
                    systemManager.updateBooking();
                    break;
                case 12:
                    systemManager.deleteBooking();
                    break;
                case 13:
                    systemManager.addRoute();
                    break;
                case 14:
                    systemManager.viewRoute();
                    break;
                case 15:
                    systemManager.updateRoute();
                    break;
                case 16:
                    systemManager.deleteRoute();
                    break;
                case 17:
                    systemManager.flightsToCSV();
                    break;
                case 18:
                    systemManager.customersToCSV();
                    break;
                case 19:
                    systemManager.bookingsToCSV();
                    break;
                case 20:
                    systemManager.routeToCSV();
                    break;
                default:
                    Utilities.writeString("Invalid option. Try again.\n");
            }
        }
    }
}
