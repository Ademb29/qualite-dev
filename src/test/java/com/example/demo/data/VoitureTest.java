package com.example.demo.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoitureTest {

    private Voiture voiture;

    @BeforeEach
    public void setUp() {
        // Cette méthode s'exécute avant CHAQUE test pour repartir sur une voiture neuve
        voiture = new Voiture("Ferrari", 200000);
    }

    @Test
    public void testVoitureCreation() {
        // Vérification que le constructeur et les getters fonctionnent
        assertEquals("Ferrari", voiture.getMarque());
        assertEquals(200000, voiture.getPrix(), 0.001);
        assertEquals(0, voiture.getVitesse(), "La vitesse initiale doit être 0");
    }

    @Test
    public void testAccelerer() {
        voiture.accelerer(50);
        assertEquals(50, voiture.getVitesse(), "La vitesse devrait être de 50");
        
        voiture.accelerer(30);
        assertEquals(80, voiture.getVitesse(), "La vitesse cumulée devrait être de 80");
    }

    @Test
    public void testFreiner() {
        voiture.accelerer(100);
        voiture.freiner(40);
        assertEquals(60, voiture.getVitesse(), "La vitesse devrait descendre à 60");
    }

    @Test
    public void testVitesseMinimum() {
        // On teste que freiner plus que la vitesse actuelle ne rend pas la vitesse négative
        voiture.accelerer(10);
        voiture.freiner(50);
        assertTrue(voiture.getVitesse() >= 0, "La vitesse ne peut pas être négative");
    }
}