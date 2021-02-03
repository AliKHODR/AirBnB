package alik.airbnb.users;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return super.equals(o) && this.responseTime == host.responseTime;
    }

    public int getResponseTime() {
        return responseTime;
    }
}
