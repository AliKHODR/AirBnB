package alik.airbnb;

import alik.airbnb.lodgement.Apartment;
import alik.airbnb.lodgement.House;
import alik.airbnb.reservations.Reservation;
import alik.airbnb.reservations.ShortStay;
import alik.airbnb.users.Host;
import alik.airbnb.users.Traveler;
import alik.airbnb.util.MyDate;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        Traveler traveler1 = new Traveler("ali", "khodr" , 28);
        Host host1 = new Host("Maxime", "Albert" , 25,12);

        /*Lodgement newLodgement = new Lodgement(host1, 80, "81 Rue Colbert, 37000 Tours", 140, 4);
        String string = "05/12/2016";
        Date date = DateFormatter.StringToDate(string);
        Stay newStay = new Stay(date, 4, newLodgement, 3);
        Person traveler = new Person("John", "Doe" , 20);
        Reservation newReservation = new Reservation(traveler1, true, newStay);
        newReservation.display();*/
        //host1.display();

        House house1 = new House(host1, 80, "81 Rue Colbert, 37000 Tours", 140, 4,500,true);
        Apartment apartment1 = new Apartment(host1, 80, "81 Rue Colbert, 37000 Tours", 140, 4,1,12);
        //String string = "05/12/2016";
        //Date date = DateFormatter.StringToDate(string);
        //Stay newStay = new Stay(date, 4, apartment1, 3);
        //newStay.display();
        MyDate date = new MyDate(7,1,2020);
        try {
            ShortStay stay = new ShortStay (date,2,house1,4);
            Reservation newReservation = new Reservation(traveler1, true, stay);
            newReservation.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
