package alik.airbnb.generic;

import java.util.ArrayList;

public class CompareMultiple<T extends Comparable<T>> {

    private final ArrayList<T> list;

    public CompareMultiple(ArrayList<T> list) throws Exception {
        if(list == null) throw new Exception("list cant be null");
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    public void add(T element) throws Exception {
        if(element == null) throw new Exception("element cant be null");
        list.add(element);
    }

    public T get(int index) {
        return list.get(index);
    }

    public T getHigher(){
        T max = list.get(0);
        for (int i = 0; i < list.size()-1; i++) {
            T a = list.get(i+1);
            max = a.compareTo(max) > 0 ? max : a;
        }
        return max;
    }
    public T getLower(){
        T min = list.get(0);
        for (int i = 0; i < list.size()-1; i++) {
            T a = list.get(i+1);
            min = a.compareTo(min) > 0 ? a : min;
        }
        return min;
    }
}
