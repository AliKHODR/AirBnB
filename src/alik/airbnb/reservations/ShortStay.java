package alik.airbnb.reservations;

import alik.airbnb.lodgement.Lodgement;

import java.util.Date;

public class ShortStay extends Stay implements PriceInterface {

    public ShortStay(Date arrivalData, int numberOfNights, Lodgement lodgement, int numberOfPersons) throws Exception {
        super(arrivalData, numberOfNights, lodgement, numberOfPersons);
    }


    @Override
    public boolean eligibleForDiscount() {
        return false;
    }

    public boolean verifyNumberOfNights() {
        return (getNumberOfNights() >= 1 && getNumberOfNights() <= 30);
    }

    @Override
    protected void updatePrice() {
        setPrice(getLodgement().getPrice() * getNumberOfNights());
    }

    public void display(){
        super.display();
    }
}
