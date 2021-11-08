package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

//Renvoyer la liste des utilisateurs
@Component
public class Stub implements AllPersonUseCase {

    Map<String, Object> persons;

    @Test
    public void getUsers(){

        persons = new HashMap<>();
        persons.put("toto",34);
        persons.put("tata",56);
        persons.put("titi",21);

        given().
                when().
        put("/persons").
                then().
        statusCode(200).log().all();
    }

    @Override
    public HashMap<String, Object> getPersons() {
        return (HashMap<String, Object>) persons;
    }
}
