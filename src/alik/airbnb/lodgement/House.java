package alik.airbnb.lodgement;

import alik.airbnb.users.Host;

public class House extends Lodgement {

    private int surfaceOfGarden;
    private boolean hasPool;

    public House(Host host, int price, String address, int surface, int maxNumberOfTraveler, int surfaceOfGarden, boolean hasPool) {
        super(host, price, address, surface, maxNumberOfTraveler);
        this.surfaceOfGarden = surfaceOfGarden;
        this.hasPool = hasPool;
    }

    public int getTotalSurface(){
        return surfaceOfGarden + getSurface();
    }

    public void display(){
        displayLodgement();
        System.out.println("Le logement est une maison située " + getAddress());
        System.out.println("Superficie : " + getSurface() + "m²");
        if(surfaceOfGarden == 0){
            System.out.println("jardin : Non");
        }else {
            System.out.println("Jardin : Oui"+ "("+surfaceOfGarden+"m²)");
        }
        if(hasPool){
            System.out.println("Piscine : Oui");
        }else {
            System.out.println("Piscine : Non");
        }
    }
}
