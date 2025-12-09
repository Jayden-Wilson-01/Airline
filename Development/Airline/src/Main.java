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
            Utilities.writeString("1: Add a customer");
            Utilities.writeString("2: View customer");
            Utilities.writeString("3: Update customer");
            Utilities.writeString("4: Delete customer");

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
                default:
                    Utilities.writeString("Invalid option. Try again.\n");
            }
        }
    }
}
