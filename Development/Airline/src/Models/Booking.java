package Models;
import Utilities.Utilities;
import java.util.Date;

public class Booking
{
    private String bookingID;
    private Date bookingDate;
    private String customerID;
    private String flightID;

    //<editor-fold desc="Get Functions">
    public String getBookingID()
    {
        return bookingID;
    }

    public Date getBookingDate()
    {
        return bookingDate;
    }

    public String getCustomerID()
    {
        return customerID;
    }

    public String getFlightID()
    {
        return flightID;
    }
    //</editor-fold>

    //<editor-fold desc="Set Functions">
    public void setBookingID(String bookingID)
    {
        if(Utilities.isNullOrWhiteSpace(this.bookingID))
        {
            this.bookingID = bookingID;
        }
    }

    public void setBookingDate(Date bookingDate)
    {
        this.bookingDate = bookingDate;
    }

    public void setCustomerID(String customerID)
    {
        if(Utilities.isNullOrWhiteSpace(this.customerID))
        {
            this.customerID = customerID;
        }
    }

    public void setFlightID(String flightID)
    {
        if(Utilities.isNullOrWhiteSpace(this.flightID))
        {
            this.flightID = flightID;
        }
    }

    //</editor-fold>
}
