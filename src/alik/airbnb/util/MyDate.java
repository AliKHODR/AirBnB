package alik.airbnb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate extends Date {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Constructeur de la classe date en format jour mois année
     * @param day
     * @param month
     * @param year
     */
    public MyDate(int day, int month, int year) {
        super(year - 1900, month - 1, day);
    }

    public MyDate(){
        super();
    }

    /**
     * method that takes a date and return a string
     * @return a date of type String formatted as dd/MM/yyyy
     */
    @Override
    public String toString() {
        return formatter.format(this);
    }
}
