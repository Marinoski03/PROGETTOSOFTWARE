/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

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
     * @param filename il nome del file su cui salvare i dati (come il metodo della libreria javafx "javafx.beans.property.StringProperty")
     */
    public void salvaSuFile(StringProperty filename) {
        // Implementazione per salvare il contatto su un file
    }
    
    /**
     * Carica un contatto da un file il cui nome è fornito come parametro.
     * Il comportamento esatto (ad esempio, formato del file, parsing, ecc.) 
     * dipende dall'implementazione che verrà fornita.
     * 
     * @param filename il nome del file da cui caricare i dati (come il metodo della libreria javafx "javafx.beans.property.StringProperty")
     * @return il contatto caricato dal file
     */
    public Contatto caricaDaFile(StringProperty filename) {
        // Implementazione per caricare il contatto da un file
        return null;  // Placeholder, da implementare
    }
}

