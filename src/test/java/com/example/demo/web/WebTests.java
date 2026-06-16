package com.example.demo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc // Permet d'injecter et de configurer l'outil MockMvc
public class WebTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPrixMoyen() throws Exception {
        // On simule une requête HTTP GET sur /prixMoyen
        this.mockMvc.perform(get("/prixMoyen"))
                .andExpect(status().isOk()) // On s'attend à recevoir un code HTTP 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Réponse au format JSON
                .andExpect(content().string(containsString("30000"))); // Optionnel: adapter selon la valeur réelle par défaut de l'application
    }

    @Test
    public void testAjouterVoiture() throws Exception {
        // En se basant sur le curl fourni dans l'énoncé, on simule une requête HTTP POST
        String voitureJson = "{\"marque\":\"Ferrari\",\"prix\":200000}";

        this.mockMvc.perform(post("/voiture")
                .contentType(MediaType.APPLICATION_JSON)
                .content(voitureJson))
                .andExpect(status().isOk()); // Vérifie que l'ajout s'est bien déroulé
    }
}