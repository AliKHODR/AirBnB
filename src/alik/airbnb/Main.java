package alik.airbnb;

import alik.airbnb.lodgement.Apartment;
import alik.airbnb.lodgement.House;
import alik.airbnb.lodgement.Lodgement;
import alik.airbnb.menu.Menu;
import alik.airbnb.reservations.LongStay;
import alik.airbnb.reservations.Reservation;
import alik.airbnb.reservations.ShortStay;
import alik.airbnb.reservations.Stay;
import alik.airbnb.users.Host;
import alik.airbnb.users.Traveler;
import alik.airbnb.util.MyDate;
import alik.airbnb.util.Search;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        Traveler traveler1 = new Traveler("ali", "khodr" , 28);
        Host host1 = new Host("Maxime", "Albert" , 25,12);

        //Lodgement newLodgement = new Lodgement(host1, 80, "81 Rue Colbert, 37000 Tours", 140, 4);
        //String string = "05/12/2016";
        //Date date = DateFormatter.StringToDate(string);
        //Stay newStay = new Stay(date, 4, newLodgement, 3);
        //Person traveler = new Person("John", "Doe" , 20);
        //Reservation newReservation = new Reservation(traveler1, true, newStay);
        //newReservation.display();
        //host1.display();

        //House house1 = new House(host1, 80, "81 Rue Colbert, 37000 Tours", 140, 4,500,true);
        //Apartment apartment1 = new Apartment(host1, 80, "81 Rue Colbert, 37000 Tours", 140, 4,1,12);
        //String string = "05/12/2016";
        //Date date = DateFormatter.StringToDate(string);
        //Stay newStay = new Stay(date, 4, apartment1, 3);
        //newStay.display();
        //MyDate date = new MyDate(20,1,2021);
        //int numberOfDays = 6;
        //Stay stay;
        /*if(numberOfDays > 5){
             stay = new LongStay (date,numberOfDays,apartment1,4);
        }else{
             stay = new ShortStay (date,numberOfDays,apartment1,4);
        }*/

        /*Reservation newReservation;
        try{
            newReservation = new Reservation(0,traveler1, stay);
            newReservation.createTextFile();
            newReservation.display();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        FileWriter writer = new FileWriter("./reservations.txt");
        writer.write("Numéro du voyageur : " + stay.getNumberOfPersons());*/
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Nicolas");
        noms.add("Aurélie");
        noms.add("Emilie");
        noms.add("Sébastian");
        noms.add("julie");
        noms.add("Audrey");
        noms.add("Alexande");
        noms.add("Julien");

        Stream<String> nomFiltre = noms.stream().filter(e -> e.startsWith("A"));

        //nomFiltre.forEach(System.out::println);

        Search search = new Search.SearchBuilder(6).build();
        List<Lodgement> result = search.result2();
        result.forEach(Lodgement::display);

        String[] arguments = new String[] {"123"};

        //Menu.main(arguments);
    }
}
