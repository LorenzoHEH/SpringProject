package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RunWith(SpringRunner.class)
class PersonControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private AllPersonUseCase allPersonUseCase;

    @Test
    void getAllPersons() {

        Person pers1 = new Person(1L,"Toto","titi",12);
        Person pers2 = new Person(1L,"Toto1","titi1",22);
        Person pers3 = new Person(3L,"Toto2","titi2",32);
        List<Person> pers = new ArrayList<>();
        pers.add(pers1);
        pers.add(pers2);
        pers.add(pers3);
        HashMap<String, Object> persons = new LinkedHashMap<>();
        persons.put("persons",pers);

        //Stub
        Mockito.when(allPersonUseCase.getPersons()).thenReturn(persons);

        baseURI ="http://localhost";
        given().
                port(port).
                when().
                get("/persons").
                then().
                statusCode(200).
                body("persons[1].lastName",equalTo("titi1")).
                body("persons.lastName",hasItems("titi","titi1","titi2"));
    }

}
