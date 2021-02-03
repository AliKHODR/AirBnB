package alik.airbnb.menu;

public class GestionLogements {

    static void listLodgements() {
        System.out.println("-------------------------------------");
        System.out.println("Liste des hôtes ");
        Menu.displayLodgments(Menu.lodgments);
        System.out.println("Saisir une option : ");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");

        switch (Menu.choice(3)) {
            case 1:
                try {
                    //addHost();
                } catch (Exception e) {
                    System.out.println("Invalid data, ("+ e.getMessage() +") veuillez resaisir les informations");
                    //Menu.scanner.nextLine();
                    listLodgements();
                }
                break;
            case 2:
                try {
                    //deleteHost();
                } catch (Exception e) {
                    System.out.println("Invalid data, veuillez choisir un hôte existant dans la list");
                    listLodgements();
                }
                break;
            case 3:
                Menu.listMenu();
                break;

        }
    }
}
