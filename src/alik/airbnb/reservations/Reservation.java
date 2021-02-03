package alik.airbnb.reservations;

import alik.airbnb.users.Person;
import alik.airbnb.users.Traveler;
import alik.airbnb.util.MyDate;

import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Reservation {
    private int id = 0;
    private Stay stay;
    private Traveler traveler;
    private boolean isValidated;
    private Date reservationDate;

    public Reservation(Traveler traveler, Stay stay) throws Exception {
        if(traveler == null) throw new Exception("traveler can't be null");
        if(stay == null) throw new Exception("traveler can't be null");
        if(!stay.verifyNumberOfPersons()){
            throw new Exception("Le nombre de voyageurs ne peut pas dépasser le Max nomber de personnes d'un logement");
        }
        if(!stay.verifyArrivalDate()){
            throw new Exception("La date d'arrivée est inférieur à la date courante");
        }
        this.traveler = traveler;
        this.id++;
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

    public void createTextFile() throws Exception {

        File myFile = new File("reservations.txt");
        /*try {
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e){
            System.out.println("An error occurred.");
        }*/

            FileWriter writer = new FileWriter(myFile.getName());
            writer.write("Numéro du voyageur : " + stay.getNumberOfPersons());
            writer.flush();
            //writer.write("Numéro du voyageur : " + stay.getLodgement().getId());
            //writer.write("Date d'arrivée (DD/MM/YYYY) : " + stay.getArrivalData());
            //writer.write("Nombre de nuits : " + stay.getNumberOfNights());
            //writer.write("Nombre de personnes) : " + stay.getNumberOfPersons());
            writer.close();

    }

    public void setStay(Stay stay) throws Exception {
        if(stay == null) throw new Exception("traveler can't be null");
        this.stay = stay;
    }

    public void setTraveler(Traveler traveler) throws Exception {
        if(traveler == null) throw new Exception("traveler can't be null");
        this.traveler = traveler;
    }
}
