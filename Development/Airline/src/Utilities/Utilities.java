package Utilities;

public class Utilities
{
    public static boolean isNullOrWhiteSpace(String string)
    {
        if (string == null || string.trim().isEmpty())
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}
