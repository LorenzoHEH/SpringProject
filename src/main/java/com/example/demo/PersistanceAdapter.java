package com.example.demo;

public class PersistanceAdapter {

    //Spring est un IoC (controle le flot d'execution)

    Person u1 = new Person(34,"toto","dushmol",45);

    public long getId()
    {
        return u1.Id;
    }
    public String getFirstName()
    {
        return u1.getFirstName();
    }
    public String getLastName()
    {
        return u1.getLastName();
    }
    public int getAge()
    {
        return u1.getAge();
    }
}
