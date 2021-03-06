package alik.airbnb.lodgement;

import alik.airbnb.users.Host;

public class House extends Lodgement {

    private final int surfaceOfGarden;
    private final boolean hasPool;

    public House(Host host, int price, String address, int surface, int maxNumberOfTraveler, int surfaceOfGarden, boolean hasPool, String name) {
        super(host, price, address, surface, maxNumberOfTraveler, name);
        this.surfaceOfGarden = surfaceOfGarden;
        this.hasPool = hasPool;
    }

    public int getTotalSurface(){
        return surfaceOfGarden + getSurface();
    }

    public boolean getHasPool(){
        return hasPool;
    }

    public int getSurfaceOfGarden() {
        return surfaceOfGarden;
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
