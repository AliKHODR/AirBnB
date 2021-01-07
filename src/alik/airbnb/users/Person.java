package alik.airbnb.users;


public class Person {
    private String firstname;
    private String lastname;
    private int age;

    public Person(String firstname, String lastname, int age){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    /**
     * method to display the firstname, lastname and age of a person
     */
    public void display(){
        System.out.print(firstname + " " + lastname + " (" + age + " ans)");
    }
}
