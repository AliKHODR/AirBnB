package alik.airbnb.generic;

import alik.airbnb.lodgement.Lodgement;
import alik.airbnb.users.Host;
import alik.airbnb.users.Person;

public class Generic<T extends Comparable<T>> {
    private final T obj1;
    private final T obj2;

    public Generic(T obj1, T obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getHigher() {
        return obj1.compareTo(obj2) > 0 ? obj2 : obj1;
    }

    public T getLower(){
        return obj1.compareTo(obj2) > 0 ? obj1 : obj2;
    }

}
