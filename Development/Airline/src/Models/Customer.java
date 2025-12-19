package Models;
import Utilities.Utilities;

public class Customer
{
    private String customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    //<editor-fold desc="Get Functions">
    public String getCustomerID()
    {
        return customerID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getAddress()
    {
        return address;
    }
    //</editor-fold>

    //<editor-fold desc="Set Functions">
    /*After initial thought I think being able to set customer ID in this case is required
    only if it hasn't already been set.*/
    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    //</editor-fold>
}
