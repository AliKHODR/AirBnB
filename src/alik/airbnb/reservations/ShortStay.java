package alik.airbnb.reservations;

import alik.airbnb.lodgement.Lodgement;

import java.util.Date;

public class ShortStay extends Stay implements PriceInterface {

    private int price;

    public ShortStay(Date arrivalData, int numberOfNights, Lodgement lodgement, int numberOfPersons) throws Exception {
        super(arrivalData, numberOfNights, lodgement, numberOfPersons);
    }


    @Override
    public int getPrice() {
        return getPrice() * getNumberOfNights();
    }

    @Override
    public boolean eligibleForDiscount() {
        return false;
    }

    public boolean verifyNumberOfNights() {
        return (getNumberOfNights() >= 1 && getNumberOfNights() <= 30);
    }
}
