package com.example.demo;

//Creation d'utilisateurs
import lombok.Getter;
public class Person {

    long Id;
    String FirstName;
    String LastName;
    int Age;

    public Person(long Id,String FirstName, String LastName, int Age)
    {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
    }

    public long getId(){
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }
}
