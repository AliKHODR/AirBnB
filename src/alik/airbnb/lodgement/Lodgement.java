package alik.airbnb.lodgement;

import alik.airbnb.users.Host;
import alik.airbnb.users.Person;

/**
 * class that represents a lodgement
 */
public abstract class Lodgement {

    private int id = 0;
    private Host host;
    private int price;
    private String address;
    private final int surface;
    private int maxNumberOfTraveler;

    public Lodgement(Host host, int price, String address, int surface, int maxNumberOfTraveler){
        this.host = host;
        this.price = price;
        this.address = address;
        this.surface = surface;
        this.maxNumberOfTraveler = maxNumberOfTraveler;
        this.id = id++;
    }

    protected void displayLodgement(){
        host.display();
        System.out.println();
        //System.out.println("Le logement est situé " + address);
        //System.out.println("Superficie : " + surface + "m²");
    }

    public int getPrice(){
        return this.price;
    }

    public int getMaxNumberOfTraveler() {
        return maxNumberOfTraveler;
    }

    public Host getHost() {
        return host;
    }

    public int getSurface() {
        return surface;
    }

    public String getAddress() {
        return address;
    }

    public abstract int getTotalSurface();

    public int getId() {
        return id;
    }

    public abstract void display();

}
