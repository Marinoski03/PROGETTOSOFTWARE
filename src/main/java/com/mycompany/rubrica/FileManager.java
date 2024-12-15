/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.StringProperty;

/**
 * La classe {@code FileManager} fornisce funzionalità per salvare e caricare dati
 * relativi ai contatti su un file.
 * I metodi di questa classe permettono di interagire con il file system per
 * memorizzare e recuperare informazioni.
 * 
 * @author obbiv
 */
public class FileManager {                   
    
    /**
     * Salva un contatto su un file il cui nome è fornito come parametro.
     * Il comportamento esatto (ad esempio, formato del file, encoding, ecc.) 
     * dipende dall'implementazione che verrà fornita.
     * 
     * @param filename il nome del file su cui salvare i dati (come { @link javafx.beans.property.StringProperty })
     */
   /*  public void salvaSuFile(String filename, Contatto c) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Scrive i dati del contatto in formato CSV: nome,cognome,telefoni,email
            writer.write(c.getNome() + "," + c.getCognome() + "," + 
                         String.join(";", c.getNumeri()) + "," + 
                         String.join(";", c.getEmail()));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del file: " + e.getMessage());
        }
    } */
    
    /**
     * Carica un contatto da un file il cui nome è fornito come parametro.
     * Il comportamento esatto (ad esempio, formato del file, parsing, ecc.) 
     * dipende dall'implementazione che verrà fornita.
     * 
     * @param filename il nome del file da cui caricare i dati (come { @link javafx.beans.property.StringProperty })
     * @return il contatto caricato dal file
     */
    public Rubrica caricaDaFileRubrica(String filename) {
        Rubrica rubrica = new Rubrica();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
               if (parts.length >= 2) {
    String nome = parts[0];
    String cognome = parts[1];
    Contatto contatto = new Contatto(nome, cognome);

    if (parts.length > 2) {
        List<String> telefoni = Arrays.asList(parts[2].split(";"));
        for (String numero : telefoni) {
            contatto.getNumeri().add(numero);
        }
    }

    if (parts.length > 3) {
        List<String> emails = Arrays.asList(parts[3].split(";"));
        for (String email : emails) {
            contatto.getEmail().add(email);
        }
    }

    rubrica.aggiungiContatto(contatto);
    } else {
                    System.err.println("Riga ignorata: formato non valido -> " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento della rubrica: " + e.getMessage());
        }
        return rubrica;
    }
    
    public void salvaSuFileRubrica(String filename, Rubrica rubrica) throws IOException {
 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        for (Contatto contatto : rubrica.getContatti()) {
            // Formato: Nome,Cognome,Numeri,Email
            String numeri = contatto.getNumeri().isEmpty() ? "" : 
                String.join(";", contatto.getNumeri());
            String email = contatto.getEmail().isEmpty() ? "" : 
                String.join(";", contatto.getEmail());
            
            writer.write(String.format("%s,%s,%s,%s\n", 
                contatto.getNome(), 
                contatto.getCognome(), 
                numeri, 
                email
            ));
        }
    }
}
}

