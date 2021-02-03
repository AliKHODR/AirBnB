package alik.airbnb.users;

import java.util.Objects;

public class Host extends Person {
    private final int responseTime;

    public Host(String firstname, String lastname, int age, int responseTime) {
        super(firstname, lastname, age);
        this.responseTime = responseTime;
    }

    @Override
    public void display(){
        super.display();
        System.out.print(" qui s'engage à répondre dans les "+ responseTime+" heure(s)");
    }

    @Override
    public boolean equals(Object o) {
        Host host = (Host) o;
        return super.equals(o) && this.responseTime == host.responseTime;
    }

}
