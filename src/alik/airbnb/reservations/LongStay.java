package alik.airbnb.reservations;

import alik.airbnb.lodgement.Lodgement;

import java.util.Date;

public class LongStay extends Stay implements PriceInterface {

    private int price;
    private int discount;
    private final int PERCENT_DISCOUNT = 20;

    public LongStay(Date arrivalData, int numberOfNights, Lodgement lodgement, int numberOfPersons) throws Exception {
        super(arrivalData, numberOfNights, lodgement, numberOfPersons);
    }

    @Override
    public int getPrice() {
        return super.getPrice() * getNumberOfNights();
    }

    @Override
    public boolean eligibleForDiscount() {
        return false;
    }

    public boolean verifyNumberOfNights() {
        return (getNumberOfNights() >= 1 && getNumberOfNights() <=31);
    }
}
