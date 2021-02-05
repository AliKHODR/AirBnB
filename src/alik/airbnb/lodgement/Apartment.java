package alik.airbnb.lodgement;

import alik.airbnb.users.Host;

public class Apartment extends Lodgement{
    private final int floor;
    private final int balconySurface;

    public Apartment(Host host, int price, String address, int surface, int maxNumberOfTraveler, int floor, int balconySurface, String name) {
        super(host, price, address, surface, maxNumberOfTraveler, name);
        this.balconySurface = balconySurface;
        this.floor = floor;
    }

    public int getTotalSurface(){
        return balconySurface + getSurface();
    }

    public int getBalconySurface() {
        return balconySurface;
    }

    public void display(){
        displayLodgement();
        System.out.print("Le logement est maison située " + getAddress());
        switch (floor){
            case 0:
                System.out.println(" au rez-de-chaussée");
                break;
            case 1:
                System.out.println(" au 1er étage");
                break;
            default:
                System.out.println(" au " + floor + "ème étage.");
        }
        System.out.println("Superficie : " + getSurface() + "m²");
        if(balconySurface == 0){
            System.out.println("Balcon : Non");
        }else{
            System.out.println("Balcon : Oui" + "("+balconySurface+"m²)");
        }
    }

}
