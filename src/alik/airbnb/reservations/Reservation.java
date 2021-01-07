package alik.airbnb.reservations;

import alik.airbnb.users.Person;
import alik.airbnb.users.Traveler;

import java.util.Date;

public class Reservation {
    private int id;
    private Stay stay;
    private Traveler traveler;
    private boolean isValidated;
    private Date reservationDate;

    public Reservation(Traveler traveler, boolean isValidated, Stay stay){
        this.traveler = traveler;
        this.isValidated = isValidated;
        this.stay = stay;
    }


    public void display(){
        traveler.display();
        System.out.print(" a fait une réservation chez ");
        stay.display();

    }
}
