package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersistanceAdapterTest {

    @Test
    public void getUsersTest()
    {
        PersistanceAdapter pm = new PersistanceAdapter();

        assertEquals(34,pm.getId());
        assertEquals("toto",pm.getFirstName());
        assertEquals("dushmol",pm.getLastName());
        assertEquals(45,pm.getAge());
    }
}
