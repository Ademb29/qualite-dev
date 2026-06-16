package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueTests {

    private StatistiqueImpl statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void prixMoyenUneVoiture() throws ArithmeticException {
        statistique.ajouter(new Voiture("BMW", 30000));
        Echantillon e = statistique.prixMoyen();
        assertEquals(1, e.getNombreDeVoitures());
        assertEquals(30000, e.getPrixMoyen());
    }

    @Test
    void prixMoyenPlusieursVoitures() throws ArithmeticException {
        statistique.ajouter(new Voiture("BMW", 10000));
        statistique.ajouter(new Voiture("Audi", 20000));
        statistique.ajouter(new Voiture("Peugeot", 30000));
        Echantillon e = statistique.prixMoyen();
        assertEquals(3, e.getNombreDeVoitures());
        assertEquals(20000, e.getPrixMoyen());
    }

    @Test
    void prixMoyenSansVoitureLanceException() {
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }
}
