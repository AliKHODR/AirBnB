package alik.airbnb.lodgement;

import alik.airbnb.users.Host;
import alik.airbnb.users.Person;

/**
 * class that represents a lodgement
 */
public abstract class Lodgement implements Comparable<Lodgement>{

    private final int id = 0;
    private final Host host;
    private final int price;
    private final String address;
    private final int surface;
    private final int maxNumberOfTraveler;
    private final String name;

    public Lodgement(Host host, int price, String address, int surface, int maxNumberOfTraveler, String name){
        this.host = host;
        this.price = price;
        this.address = address;
        this.surface = surface;
        this.maxNumberOfTraveler = maxNumberOfTraveler;
        this.name = name;
        //this.id = id++;
    }

    protected void displayLodgement(){
        host.display();
        System.out.println();
        System.out.println(name);
        //System.out.println("Le logement est situé " + address);
        //System.out.println("Superficie : " + surface + "m²");
    }

    public int getPrice(){
        return this.price;
    }

    public int getMaxNumberOfTraveler() {
        return maxNumberOfTraveler;
    }


    public int getSurface() {
        return surface;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public abstract int getTotalSurface();


    public abstract void display();

    @Override
    public int compareTo(Lodgement o) {
        return  o.price > price ? 1 : 0;
    }

}
