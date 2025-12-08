package Models;

import Utilities.Utilities;

import java.util.Date;

public class Flight
{
    private String flightID;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private Date departureDateTime;
    private Date arrivalDateTime;

    //<editor-fold desc="Get Functions">
    public String getFlightID()
    {
        return flightID;
    }

    public String getFlightNumber()
    {
        return flightNumber;
    }

    public String getDepartureAirport()
    {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getDepartureDateTime()
    {
        return departureDateTime;
    }

    public Date getArrivalDateTime()
    {
        return arrivalDateTime;
    }
    //</editor-fold>

    //<editor-fold desc="Set Functions">
    public void setFlightID(String flightID)
    {
        if(Utilities.isNullOrWhiteSpace(this.flightID))
        {
            this.flightID = flightID;
        }
    }

    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public void setDepartureAirport(String departureAirport)
    {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(String arrivalAirport)
    {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDepartureDateTime(Date departureDateTime)
    {
        this.departureDateTime = departureDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime)
    {
        this.arrivalDateTime = arrivalDateTime;
    }
    //</editor-fold>
}
