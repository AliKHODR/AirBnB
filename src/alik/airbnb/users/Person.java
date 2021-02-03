package alik.airbnb.users;


import java.util.Objects;

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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname);
    }

}
