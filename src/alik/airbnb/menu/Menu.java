package alik.airbnb.menu;

import alik.airbnb.users.Host;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner;
    static ArrayList<Host> hosts;


    public static void main(String[] args) {
        System.out.println("Bienvenue chez AirBnB");
        scanner = new Scanner(System.in);
        hosts = new ArrayList<>();
        listMenu();
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
                System.out.println("les logements");
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
            userInput = getInteger(maxValue);
            if (userInput >= 1 && userInput <= maxValue){
                isValid = true;
            }else {
                System.out.println("invalid value, saisissez un numéro entre 1 et "+ maxValue);
            }
        }while (!isValid);

        return userInput;
    }
    public static void displayArray(ArrayList<Host> arrayList){
        for (int i = 0; i < arrayList.size(); i++){
            System.out.print("n°"+i+" : ");
            arrayList.get(i).display();
            System.out.println();
        }
    }
}
