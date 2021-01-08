package alik.airbnb.menu;

import alik.airbnb.users.Host;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestionHotes {

    static void listHosts() {
        System.out.println("-------------------------------------");
        System.out.println("Liste des hôtes ");
        Menu.displayArray(Menu.hosts);
        System.out.println("Saisir une option : ");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");

        //Menu.displayArray(host);
        switch (Menu.choice(3)) {
            case 1:
                try {
                    addHost();
                } catch (Exception e) {
                    System.out.println("Invalid data, ("+ e.getMessage() +") veuillez resaisir les informations");
                    //Menu.scanner.nextLine();
                    listHosts();
                }
                break;
            case 2:
                try {
                    deleteHost();
                } catch (Exception e) {
                    System.out.println("Invalid data, veuillez choisir un hôte existant dans la list");
                    listHosts();
                }
                break;
            case 3:
                Menu.listMenu();
                break;

        }
    }
    static void addHost() throws Exception {
        System.out.println("Prénom : ");
        Menu.scanner.nextLine();
        String firstname = Menu.scanner.nextLine();
        if(!checkString(firstname) || firstname.isBlank()){
            throw new Exception("Un Prénom ne peut être ni vide, ni numérique, il doit être alphanumérique");
        }

        System.out.println("Nom : ");
        String lastname = Menu.scanner.nextLine();
        if(!checkString(lastname) || lastname.isBlank()){
            throw new Exception("Un Nom ne peut être ni vide, ni numérique, il doit être alphanumérique");
        }
        System.out.println("age : ");
        int age = Menu.scanner.nextInt();
        if(age < 16 || age > 100){
            throw new Exception("l'age doit être entre 16 et 100 ans");
        }

        System.out.println("Delais reponse :");
        int responseTime = Menu.scanner.nextInt();
        if(responseTime < 0 || responseTime > 840){
            throw new Exception("Le delai doit être entre 0 et 840 heure(s)(2 semaines)");
        }
        Host host = new Host(firstname,lastname,age,responseTime);
        Menu.hosts.add(host);
        System.out.println(lastname+" "+firstname+ " ("+age+" ans). Son délai de réponse est de "+responseTime+" jour(s).");
        listHosts();
    }

    static void deleteHost() throws Exception{
        if (Menu.hosts.size() == 0 ){
            System.out.println("pas d'hôte à supprimer");
            listHosts();
        }
        System.out.println("Entrez le numéro d'hôte que vous souhaitez supprimer");
        int hostIndex = Menu.scanner.nextInt();
        /*if(hostIndex > Menu.hosts.size()){
            throw new Exception("Cet hôte n'existe pas, veuillez choisir un hôte existant");
        }*/
        Menu.hosts.remove(hostIndex);
        System.out.println("Le hôte n° " + hostIndex + " a été supprimé ( "+ Menu.hosts.get(hostIndex).getFirstname() + Menu.hosts.get(hostIndex).getLastname() +") ");
        listHosts();
    }

    static boolean checkString(String s){
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(s);
        return m.find();
    }
}
