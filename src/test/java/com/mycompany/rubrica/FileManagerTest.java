/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per la classe FileManager.
 */
public class FileManagerTest {

    private FileManager fileManager;
    private String testFile;

    @BeforeEach
    public void setUp() {
        fileManager = new FileManager();
        testFile = "test_rubrica.csv";
    }

    @AfterEach
    public void tearDown() {
        try {
            Files.deleteIfExists(Paths.get(testFile));
        } catch (IOException e) {
            System.err.println("Errore durante l'eliminazione del file di test: " + e.getMessage());
        }
    }

    @Test
    public void testSalvaSuFile() {
        Contatto contatto = new Contatto("Mario", "Rossi");
        contatto.aggiungiNumero("1234567890");
        contatto.aggiungiEmail("mario.rossi@example.com");

        fileManager.salvaSuFile(testFile, contatto);

        // Verifica che il file esista
        assertTrue(Files.exists(Paths.get(testFile)), "Il file non è stato creato.");

        // Verifica il contenuto del file
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line = reader.readLine();
            assertEquals("Mario,Rossi,1234567890,mario.rossi@example.com", line, "Il contenuto del file non è corretto.");
        } catch (IOException e) {
            fail("Errore durante la lettura del file di test: " + e.getMessage());
        }
    }

    @Test
    public void testCaricaDaFileRubrica() {
        String content = "Luigi,Bianchi,0987654321,luigi.bianchi@example.com\n" +"Mario,Rossi,1234567890,mario.rossi@example.com\n"
                          ;

        try {
            Files.write(Paths.get(testFile), content.getBytes());
        } catch (IOException e) {
            fail("Errore durante la scrittura del file di test: " + e.getMessage());
        }

        Rubrica rubrica = fileManager.caricaDaFileRubrica(testFile);

        // Verifica che i contatti siano stati caricati correttamente
        assertEquals(2, rubrica.getContatti().size(), "Il numero di contatti caricati non è corretto.");

        Contatto primo = rubrica.getContatti().get(0);
        assertEquals("Luigi", primo.getNome(), "Il nome del primo contatto non è corretto.");
        assertEquals("Bianchi", primo.getCognome(), "Il cognome del primo contatto non è corretto.");
        assertEquals("0987654321", primo.getNumeri().get(0), "Il numero del primo contatto non è corretto.");
        assertEquals("luigi.bianchi@example.com", primo.getEmail().get(0), "L'email del primo contatto non è corretta.");

        Contatto secondo = rubrica.getContatti().get(1);
        assertEquals("Mario", secondo.getNome(), "Il nome del secondo contatto non è corretto.");
        assertEquals("Rossi", secondo.getCognome(), "Il cognome del secondo contatto non è corretto.");
        assertEquals("1234567890", secondo.getNumeri().get(0), "Il numero del secondo contatto non è corretto.");
        assertEquals("mario.rossi@example.com", secondo.getEmail().get(0), "L'email del secondo contatto non è corretta.");
    }

    @Test
    public void testSalvaSuFileRubrica() {
        Rubrica rubrica = new Rubrica();
        Contatto c1 = new Contatto("Luigi", "Bianchi");
        c1.aggiungiNumero("0987654321");
        c1.aggiungiEmail("luigi.bianchi@example.com"); 
        
        Contatto c2 = new Contatto("Mario", "Rossi");
        c2.aggiungiNumero("1234567890");
        c2.aggiungiEmail("mario.rossi@example.com");


        rubrica.aggiungiContatto(c1);
        rubrica.aggiungiContatto(c2);

        try {
            fileManager.salvaSuFileRubrica(testFile, rubrica);
        } catch (IOException e) {
            fail("Errore durante il salvataggio della rubrica: " + e.getMessage());
        }

        // Verifica che il file esista
        assertTrue(Files.exists(Paths.get(testFile)), "Il file non è stato creato.");

        // Verifica il contenuto del file
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line1 = reader.readLine(); 
            assertEquals("Luigi,Bianchi,0987654321,luigi.bianchi@example.com", line1, "Il contenuto del secondo contatto non è corretto.");
            

            String line2 = reader.readLine();
            assertEquals("Mario,Rossi,1234567890,mario.rossi@example.com", line2, "Il contenuto del primo contatto non è corretto.");
            
        } catch (IOException e) {
            fail("Errore durante la lettura del file di test: " + e.getMessage());
        }
    }
}

