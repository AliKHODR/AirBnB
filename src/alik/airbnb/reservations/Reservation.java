package alik.airbnb.reservations;

import alik.airbnb.users.Person;
import alik.airbnb.users.Traveler;
import alik.airbnb.util.MyDate;

import java.util.Date;

public class Reservation {
    private int id;
    private Stay stay;
    private Traveler traveler;
    private boolean isValidated;
    private Date reservationDate;

    public Reservation(int id,Traveler traveler, Stay stay){
        this.traveler = traveler;
        this.id = id;
        this.stay = stay;
        reservationDate = new MyDate();
        isValidated = false;
    }

    public void display(){
        System.out.println("Bienvenue chez AirBnB");
        System.out.println("Réservation n"+ id);
        System.out.println("Fait le "+ reservationDate);
        traveler.display();
        System.out.print(" a fait une réservation chez ");
        stay.display();

    }
}
