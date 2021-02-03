package alik.airbnb.reservations;

import alik.airbnb.lodgement.Lodgement;

import java.util.Date;

public class LongStay extends Stay implements PriceInterface {

    private int discount;
    private final int PERCENT_DISCOUNT = 20;

    public LongStay(Date arrivalData, int numberOfNights, Lodgement lodgement, int numberOfPersons) {
        super(arrivalData, numberOfNights, lodgement, numberOfPersons);
    }

    @Override
    public boolean eligibleForDiscount() {
        return true;
    }

    public boolean verifyNumberOfNights() {
        return (getNumberOfNights() >= 1 && getNumberOfNights() <=31);
    }

    @Override
    protected void updatePrice() {
        int initialPrice = getLodgement().getPrice() * getNumberOfNights();
        discount = (initialPrice * PERCENT_DISCOUNT)/100;
        int priceAfterDiscount = initialPrice - discount;
        setPrice(priceAfterDiscount);
    }

    @Override
    public void display(){
        super.display();
        System.out.println("("+discount+" € de promotion)"  );
    }

}
