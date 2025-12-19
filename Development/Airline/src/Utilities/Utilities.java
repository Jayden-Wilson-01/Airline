package Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utilities
{
    //Checks if a string is null or is empty (white space)
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

    //Allow user to enter an input based on a string value
    public static String readString(String prompt)
    {
        Scanner input = new Scanner(System.in);

        while (true)
        {
            System.out.print(prompt);
            String value = input.nextLine();

            if (isNullOrWhiteSpace(value) == false)
            {
                return value.trim();   // return cleaned input
            }

            System.out.println("Input cannot be empty. Try again.");
        }
    }

    //Allow user to enter a date input based on a string value
    public static Date readDate(String prompt)
    {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);

        while (true)
        {
            System.out.print(prompt);
            String value = input.nextLine();

            if (isNullOrWhiteSpace(value))
            {
                System.out.println("Input cannot be empty. Try again.");
                continue;
            }

            try
            {
                return formatter.parse(value);
            }
            catch (ParseException e)
            {
                System.out.println("Invalid date format. Use dd/MM/yyyy. Try again.");
            }
        }
    }

    //Allow user to enter an int input based on a string value
    public static int readInt(String prompt)
    {
        Scanner input = new Scanner(System.in);

        while (true)
        {
            try
            {
                System.out.print(prompt);
                return input.nextInt(); // returns when valid

            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input. Try again.");
                input.nextLine(); // clear invalid input
            }
        }
    }

    //Allow user to write string value to the console
    public static void writeString(String string)
    {
        System.out.println(string);
    }
}
