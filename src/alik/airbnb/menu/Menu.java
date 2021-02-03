package alik.airbnb.menu;

import alik.airbnb.generic.Generic;
import alik.airbnb.lodgement.Apartment;
import alik.airbnb.lodgement.House;
import alik.airbnb.lodgement.Lodgement;
import alik.airbnb.users.Host;
import alik.airbnb.util.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner;
    static ArrayList<Host> hosts;
    static ArrayList<Lodgement> lodgments;


    public static void main(String[] args) {
        System.out.println("Bienvenue chez AirBnB");
        scanner = new Scanner(System.in);
        hosts = new ArrayList<>();
        lodgments = new ArrayList<>();

        try {
            init();
        } catch (ParserConfigurationException e) {
            System.out.println("1");
            e.getMessage();
        } catch (SAXException e) {
            System.out.println("2");
            e.getMessage();
        } catch (IOException e) {
            System.out.println("3");
            scanner.nextLine();
        }

        //Apartment apartment = findLodgmentByNameWithGenericity("Bardu0");
        //apartment.display();
        Generic<Lodgement> lodgementGeneric = new Generic<>(lodgments.get(2),lodgments.get(1));
        Lodgement moreExpensiveLodgment = lodgementGeneric.getLower();
        System.out.println(moreExpensiveLodgment.getPrice());
        //listMenu();
        scanner.close();
    }
    static void listMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Saisir une option");
        System.out.println("1 : Liste des hôtes");
        System.out.println("2 : Liste des logements");
        System.out.println("3 : Liste des voyageurs");
        System.out.println("4 : Liste des réservations");
        System.out.println("5 : Fermer le programme");
        switch (choice(5)){
            case 1:
                GestionHotes.listHosts();
                break;
            case 2:
                GestionLogements.listLodgements();
                break;
            case 3:
                System.out.println("les voyageurs");
                break;
            case 4:
                System.out.println("les réservations");
                break;
            case 5:
                System.out.println("A bientôt");
                break;
        }

    }
    public static int getInteger(int maxValue){
        int userInput = 0;
        boolean isInteger = false;
        do{
            try{
                userInput = scanner.nextInt();
                isInteger = true;

            }catch (InputMismatchException e){
                System.out.println("invalid value, saisissez un numéro entre 1 et "+ maxValue);
                scanner.nextLine();
            }
        }while (!isInteger);
        return userInput;
    }

    public static int choice(int maxValue) {
        int userInput = 0;
        boolean isValid = false;
        do{
            try {
                userInput = scanner.nextInt();
                if (userInput >= 1 && userInput <= maxValue){
                    isValid = true;
                }else {
                    System.out.println("invalid value, saisissez un numéro entre 1 et "+ maxValue);
                }
            }catch (Exception e){
                System.out.println("invalid value, saisissez un numéro entre 1 et "+ maxValue);
                scanner.nextLine();
            }
        }while (!isValid);
        return userInput;
    }

    public static void displayHosts(ArrayList<Host> arrayList){
        for (int i = 0; i < arrayList.size(); i++){
            System.out.print("n°"+i+" : ");
            arrayList.get(i).display();
            System.out.println();
        }
    }
    public static void displayLodgments(ArrayList<Lodgement> arrayList){
        for (int i = 0; i < arrayList.size(); i++){
            System.out.print("n°"+i+" : ");
            arrayList.get(i).display();
            System.out.println();
        }
    }

    static void init() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLParser xmlParser = new XMLParser();
        saxParser.parse("./src/logements.xml",xmlParser);
        hosts = xmlParser.getHosts();
        lodgments = xmlParser.getLodgements();
    }


    private static Apartment findApartmentByName(String name){
        for (int i = 0; i < lodgments.size(); i++) {
            if(lodgments.get(i) instanceof Apartment){
                if(lodgments.get(i).getName().equals(name)){
                    return (Apartment) lodgments.get(i);
                }
            }
        }
        return null;
    }
    private static House findHouseByName(String name){
        for (int i = 0; i < lodgments.size(); i++) {
            if(lodgments.get(i) instanceof House){
                if(lodgments.get(i).getName().equals(name)){
                    return (House) lodgments.get(i);
                }
            }
        }
        return null;
    }
    private static Lodgement findLodgmentByName(String name){
        for (int i = 0; i < lodgments.size(); i++) {
            if(lodgments.get(i).getName().equals(name)){
                return lodgments.get(i);
            }
        }
        return null;
    }

    private static  <T extends Lodgement>T findLodgmentByNameWithGenericity(String name){
        for (int i = 0; i < lodgments.size(); i++) {
            if(lodgments.get(i).getName().equals(name)){
                return (T) lodgments.get(i);
            }
        }
        return null;
    }
}
