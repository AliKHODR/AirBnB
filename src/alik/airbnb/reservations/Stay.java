package alik.airbnb.reservations;

import alik.airbnb.util.DateFormatter;
import alik.airbnb.lodgement.Lodgement;

import java.util.Date;

public abstract class Stay implements StayInterface{

    private Date arrivalData;
    private int numberOfNights;
    private Lodgement lodgement;
    private int numberOfPersons;

    public Stay(Date arrivalData, int numberOfNights, Lodgement lodgement, int numberOfPersons) throws Exception {
        this.numberOfNights = numberOfNights;
        if(!verifyNumberOfNights()){
            System.out.println(numberOfNights);
            throw new Exception("Exception message");
        }
        this.arrivalData = arrivalData;
        this.lodgement = lodgement;
        this.numberOfPersons = numberOfPersons;
    }

    @Override
    public boolean verifyArrivalDate() {
        return arrivalData.after(new Date());
    }


    public abstract boolean verifyNumberOfNights();

    @Override
    public boolean verifyNumberOfPersons() {
       return numberOfPersons <= lodgement.getMaxNumberOfTraveler();
    }

    public void display(){
        lodgement.display();
        String date = DateFormatter.DateToString(arrivalData);
        System.out.println("La date d'arrivée est le " + date + " pour " + numberOfNights + " nuits");
        System.out.println("Le prix de ce séjour est de " + lodgement.getPrice() + "€");
    }

    public int getPrice(){

        return lodgement.getPrice();
    }

    public int getNumberOfNights(){
        return numberOfNights;
    }
}
