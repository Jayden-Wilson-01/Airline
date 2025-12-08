package Models;

import Utilities.Utilities;

import java.util.Date;

public class Route
{
    private String routeID;
    private Date routeName;

    //<editor-fold desc="Get Functions">
    public String getRouteID()
    {
        return routeID;
    }

    public Date getRouteName()
    {
        return routeName;
    }
    //</editor-fold>

    //<editor-fold desc="Set Functions">
    public void setRouteID(String routeID)
    {
        if(Utilities.isNullOrWhiteSpace(this.routeID))
        {
            this.routeID = routeID;
        }
    }

    public void setRouteName(Date routeName)
    {
        this.routeName = routeName;
    }

    //</editor-fold>
}
