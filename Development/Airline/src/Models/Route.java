package Models;

import Utilities.Utilities;

import java.util.Date;

public class Route
{
    private String routeID;
    private String routeName;

    //<editor-fold desc="Get Functions">
    public String getRouteID()
    {
        return routeID;
    }

    public String getRouteName()
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

    public void setRouteName(String routeName)
    {
        this.routeName = routeName;
    }

    //</editor-fold>
}
