package alik.airbnb.reservations;

import alik.airbnb.lodgement.Lodgement;
import java.util.Date;

public final class StayFactory {

    // On ajoute un constructor privée pour ne pas pouvoir instintier la classe
    private StayFactory(){

    }
    public static Stay getStay(Date arrivalDate, Lodgement lodgement, int numberOfNights, int numberOfPersons){
        Stay stay;
        if(numberOfNights > 5){
             stay = new LongStay (arrivalDate,numberOfNights,lodgement,numberOfPersons);
        }else{
             stay = new ShortStay (arrivalDate,numberOfNights,lodgement,numberOfPersons);
        }
        return stay;
    }
}
