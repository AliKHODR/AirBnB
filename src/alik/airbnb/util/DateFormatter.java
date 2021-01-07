package alik.airbnb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * utility class to manipulate the f**king dates
 */
public class DateFormatter {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * method that takes a string and returns a Date object
     * @param string
     * @return Date
     * @throws ParseException
     */
    public static Date StringToDate(String string) throws ParseException {
        return formatter.parse(string);
    }

    /**
     * method that takes a date and return a string
     * @param date
     * @return a date of type String formatted as dd/MM/yyyy
     */
    public static String DateToString(Date date) {
        return formatter.format(date);
    }
}
