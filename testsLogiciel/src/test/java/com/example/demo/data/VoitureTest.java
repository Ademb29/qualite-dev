package com.example.demo.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoitureTest {

    @Test
    void testConstructeurVide() {
        Voiture v = new Voiture();
        assertNull(v.getMarque());
        assertEquals(0, v.getPrix());
    }

    @Test
    void testConstructeurAvecParametres() {
        Voiture v = new Voiture("BMW", 20000);
        assertEquals("BMW", v.getMarque());
        assertEquals(20000, v.getPrix());
    }

    @Test
    void testSetId() {
        Voiture v = new Voiture();
        v.setId(1);
        assertEquals(1, v.getId());
    }

    @Test
    void testSetMarque() {
        Voiture v = new Voiture();
        v.setMarque("Audi");
        assertEquals("Audi", v.getMarque());
    }

    @Test
    void testSetPrix() {
        Voiture v = new Voiture();
        v.setPrix(15000);
        assertEquals(15000, v.getPrix());
    }

    @Test
    void testToString() {
        Voiture v = new Voiture("Peugeot", 10000);
        v.setId(5);

        String result = v.toString();

        assertTrue(result.contains("Peugeot"));
        assertTrue(result.contains("10000"));
        assertTrue(result.contains("5"));
    }
}