package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.data.Voiture;

@ExtendWith(MockitoExtension.class)
public class StatistiqueTests {

    @Mock
    private Echantillon echantillonMock; // On simule la classe qui fournit les données

    @InjectMocks
    private StatistiqueImpl statistiqueService; // Injecte le mock ci-dessus dans le service à tester

    private List<Voiture> listeVoitures;

    @BeforeEach
    public void setUp() {
        // Préparation d'un jeu de données de test
        listeVoitures = new ArrayList<>();
        listeVoitures.add(new Voiture("Renault", 15000));
        listeVoitures.add(new Voiture("Peugeot", 25000));
        listeVoitures.add(new Voiture("Tesla", 50000));
    }

    @Test
    public void testPrixMoyen() {
        // En se basant sur le comportement de Echantillon :
        // "Quand on appelle echantillonMock.getVoitures(), alors renvoie listeVoitures"
        when(echantillonMock.getVoitures()).thenReturn(listeVoitures);

        // Calcul attendu : (15000 + 25000 + 50000) / 3 = 30000
        double prixMoyenCalcule = statistiqueService.prixMoyen();

        assertEquals(30000, prixMoyenCalcule, 0.001, "Le prix moyen calculé est incorrect");
        
        // Optionnel : On vérifie que la méthode du mock a bien été appelée une fois
        verify(echantillonMock, times(1)).getVoitures();
    }

    @Test
    public void testPrixMoyenEchantillonVide() {
        // Cas limite : que se passe-t-il si la liste est vide ?
        when(echantillonMock.getVoitures()).thenReturn(new ArrayList<>());

        double prixMoyenCalcule = statistiqueService.prixMoyen();

        assertEquals(0, prixMoyenCalcule, 0.001, "Le prix moyen d'un échantillon vide doit être 0");
    }
}