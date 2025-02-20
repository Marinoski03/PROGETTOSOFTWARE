/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*; //importa in modo statico tutti i metodi di asserzione di JUnit//
import java.util.List;

class ContattoTest {

    private Contatto contatto;

    @BeforeEach 
    void setUp() {
        contatto = new Contatto("Mario", "Rossi"); 
    }

    @Test
    void testCostruttore() { //verifica che il costruttore di contatto inizializzi correttamente i campi 
        assertEquals("Mario", contatto.getNome()); 
        assertEquals("Rossi", contatto.getCognome());
        assertTrue(contatto.getNumeri().isEmpty()); 
        assertTrue(contatto.getEmail().isEmpty());
    }

    @Test
    void testAggiungiNumero() {
        contatto.aggiungiNumero("1234567890"); 
        contatto.aggiungiNumero("0987654321");
        contatto.aggiungiNumero("1122334455");

        List<String> numeri = contatto.getNumeri(); //recupera la lista dei numeri del contatto//
        assertEquals(3, numeri.size()); //controlla se sono esattamente 3//
        assertTrue(numeri.contains("1234567890")); 
        assertTrue(numeri.contains("0987654321"));
        assertTrue(numeri.contains("1122334455"));

        // Non dovrebbe aggiungere un quarto numero
        contatto.aggiungiNumero("5566778899");
        assertEquals(3, numeri.size());
    }

    @Test
    void testRimuoviNumero() {
        contatto.aggiungiNumero("1234567890");
        contatto.aggiungiNumero("0987654321");
        contatto.rimuoviNumero("1234567890");

        List<String> numeri = contatto.getNumeri();
        assertEquals(1, numeri.size());
        assertFalse(numeri.contains("1234567890"));
    }

    @Test
    void testAggiungiEmail() {
        contatto.aggiungiEmail("test1@example.com");
        contatto.aggiungiEmail("test2@example.com");
        contatto.aggiungiEmail("test3@example.com");

        List<String> email = contatto.getEmail();
        assertEquals(3, email.size());
        assertTrue(email.contains("test1@example.com"));

        // Non dovrebbe aggiungere una quarta email
        contatto.aggiungiEmail("test4@example.com");
        assertEquals(3, email.size());
    }

    @Test
    void testRimuoviEmail() {
        contatto.aggiungiEmail("test1@example.com");
        contatto.aggiungiEmail("test2@example.com");
        contatto.rimuoviEmail("test1@example.com");

        List<String> email = contatto.getEmail();
        assertEquals(1, email.size());
        assertFalse(email.contains("test1@example.com"));
    }

    @Test
    void testSetNomeCognome() {
        contatto.setNome("Luigi"); //modifica il contatto in Luigi Verdi//
        contatto.setCognome("Verdi");

        assertEquals("Luigi", contatto.getNome());
        assertEquals("Verdi", contatto.getCognome());
    }

    @Test
    void testToString() {
        assertEquals("Rossi Mario", contatto.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Contatto altroContatto = new Contatto("Mario", "Rossi");
        assertEquals(contatto, altroContatto);
        assertEquals(contatto.hashCode(), altroContatto.hashCode());

        Contatto diverso = new Contatto("Luigi", "Verdi");
        assertNotEquals(contatto, diverso);
    }
}

