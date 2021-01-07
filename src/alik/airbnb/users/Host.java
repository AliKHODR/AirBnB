package alik.airbnb.users;

public class Host extends Person {
    private int responseTime;

    public Host(String firstname, String lastname, int age, int responseTime) {
        super(firstname, lastname, age);
        this.responseTime = responseTime;
    }

    @Override
    public void display(){
        super.display();
        System.out.print(" qui s'engage à répondre dans les "+ responseTime+" heure(s)");
        //System.out.println();
        //super.display();
        //System.out.print(" qui s'engage à répondre dans l'heure");
    }
}
