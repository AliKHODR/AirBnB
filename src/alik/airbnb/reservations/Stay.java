package alik.airbnb.reservations;

import alik.airbnb.util.DateFormatter;
import alik.airbnb.lodgement.Lodgement;

import java.util.Date;

public abstract class Stay implements StayInterface{

    private Date arrivalData;
    private int numberOfNights;
    private Lodgement lodgement;
    private int numberOfPersons;

    private int price;

    public Stay(Date arrivalData, int numberOfNights, Lodgement lodgement, int numberOfPersons) {

        this.numberOfNights = numberOfNights;
        this.arrivalData = arrivalData;
        this.lodgement = lodgement;
        this.numberOfPersons = numberOfPersons;

        updatePrice();

    }

    //public abstract boolean verifyNumberOfNights();

    protected abstract void updatePrice();

    @Override
    public boolean verifyArrivalDate() {
        return arrivalData.after(new Date());
    }

    @Override
    public boolean verifyNumberOfPersons() {
       return numberOfPersons <= lodgement.getMaxNumberOfTraveler();
    }

    public void display(){
        lodgement.display();
        System.out.println("La date d'arrivée est le " + arrivalData + " pour " + numberOfNights + " nuits");
        System.out.print("Le prix de ce séjour est de " + price + "€ ");
    }

    public int getNumberOfNights(){
        return numberOfNights;
    }

    public int getPrice(){
        return price;
    }

    public Date getArrivalData() {
        return arrivalData;
    }

    protected void setPrice(int price){
        this.price = price;
    }

    protected Lodgement getLodgement() {
        return lodgement;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }
}
