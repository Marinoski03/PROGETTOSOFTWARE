/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RubricaTest {

    private Rubrica rubrica;
    private Contatto contatto1;
    private Contatto contatto2;
    private Contatto contatto3;

    @BeforeEach
    void setUp() {
        rubrica = new Rubrica();
        contatto1 = new Contatto("Mario", "Rossi");
        contatto2 = new Contatto("Luigi", "Bianchi");
        contatto3 = new Contatto("Anna", "Verdi");
    }

    @Test
    void testAggiungiContatto() {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(2, contatti.size());
        assertTrue(contatti.contains(contatto1));
        assertTrue(contatti.contains(contatto2));
    }

    @Test
    void testEliminaContatto() {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        rubrica.eliminaContatto(contatto1);

        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(1, contatti.size());
        assertFalse(contatti.contains(contatto1));
        assertTrue(contatti.contains(contatto2));
    }

    @Test
    void testOrdinaContatti() {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        rubrica.aggiungiContatto(contatto3);

        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(contatto2, contatti.get(0)); // Luigi Bianchi
        assertEquals(contatto1, contatti.get(1)); // Mario Rossi
        assertEquals(contatto3, contatti.get(2)); // Anna Verdi
    }

    @Test
    void testGetContatti() {
        rubrica.aggiungiContatto(contatto1);
        ObservableList<Contatto> contatti = rubrica.getContatti();

        assertNotNull(contatti);
        assertEquals(1, contatti.size());
        assertEquals(contatto1, contatti.get(0));
    }

    @Test
    void testListaOsservabile() {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        ObservableList<Contatto> contatti = rubrica.getContatti();

        contatti.remove(contatto1);
        assertFalse(rubrica.getContatti().contains(contatto1));
        assertTrue(rubrica.getContatti().contains(contatto2));
    }
}

