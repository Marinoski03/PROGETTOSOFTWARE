/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import java.util.TreeSet;
import javafx.collections.ObservableList;

/**
 * La classe {@code Rubrica} gestisce una raccolta di contatti, permettendo di
 * aggiungere, modificare, eliminare e cercare contatti all'interno di una rubrica.
 * I contatti sono memorizzati in un insieme ordinato (TreeSet), che garantisce
 * che i contatti siano unici e ordinati in base all'implementazione dell'interfaccia
 * {@link Comparable} nella classe {@link Contatto}.
 * 
 * @author obbiv
 */
public class Rubrica {

    // Collezione di contatti ordinata per nome e cognome (tramite TreeSet)
    private TreeSet<Contatto> contatti;
    
    /**
     * Costruttore che inizializza la rubrica come una collezione vuota di contatti.
     */
    public Rubrica(){
        contatti = new TreeSet<>();  // Inizializza il TreeSet per mantenere i contatti ordinati
    }
    
    /**
     * Aggiunge un nuovo contatto alla rubrica.
     * Se il contatto esiste già, non verrà aggiunto (TreeSet non permette duplicati).
     * 
     * @param c il contatto da aggiungere alla rubrica
     */
    public void aggiungiContatto(Contatto c){
        contatti.add(c);  // Aggiunge il contatto al TreeSet
    }
    
    /**
     * Modifica un contatto esistente nella rubrica.
     * La logica di modifica dipende dall'implementazione specifica,
     * ma generalmente consiste nel rimuovere il contatto e aggiungerlo nuovamente
     * con i dati modificati.
     * 
     * @param c il contatto da modificare
     */
    public void modificaContatto(Contatto c){
        // Implementazione per modificare il contatto nella rubrica
    }
    
    /**
     * Elimina un contatto dalla rubrica.
     * Se il contatto non esiste, non verrà fatto nulla.
     * 
     * @param c il contatto da eliminare
     */
    public void eliminaContatto(Contatto c){
        // Implementazione per eliminare il contatto dalla rubrica
    }
    
    /**
     * Cerca i contatti che corrispondono alla stringa di ricerca fornita.
     * Restituisce una lista di contatti che contengono il termine di ricerca
     * nel nome, cognome o nei numeri di telefono o email (la ricerca può essere
     * implementata in modo più sofisticato).
     * 
     * @param s la stringa da cercare (può essere una parte del nome o cognome)
     * @return una lista osservabile di contatti che corrispondono alla ricerca
     */
    public ObservableList<Contatto> cercaContatto(String s){
        // Implementazione della ricerca dei contatti
        return null;  // Placeholder, da implementare
    }
}
