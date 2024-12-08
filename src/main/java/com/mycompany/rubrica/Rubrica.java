/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import java.util.TreeSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe che rappresenta una rubrica, che contiene una lista di contatti.
 * La rubrica consente di aggiungere, modificare, eliminare e cercare contatti,
 * nonché di ottenere la lista ordinata dei contatti.
 * 
 * @author obbiv
 */
public class Rubrica {

    // Lista dei contatti nella rubrica
    private ObservableList<Contatto> contatti;

    /**
     * Costruttore della classe Rubrica.
     * Inizializza una rubrica vuota con una lista di contatti vuota.
     */
    public Rubrica(){
        contatti = FXCollections.observableArrayList();  
    }

    /**
     * Aggiunge un contatto alla rubrica e ordina i contatti per cognome e nome.
     * 
     * @param c Il contatto da aggiungere alla rubrica.
     */
    public void aggiungiContatto(Contatto c){
        contatti.add(c); 
        ordinaContatti();
    }

    /**
     * Modifica un contatto nella rubrica.
     * Questo metodo è attualmente non implementato, ma può essere usato per aggiornare
     * le informazioni di un contatto esistente.
     * 
     * @param c Il contatto da modificare.
     */
    public void modificaContatto(Contatto c){
        // Implementazione per modificare il contatto nella rubrica (non ancora implementato)
    }

    /**
     * Elimina un contatto dalla rubrica.
     * 
     * @param c Il contatto da eliminare dalla rubrica.
     */
    public void eliminaContatto(Contatto c){
        contatti.remove(c);
    }

    /**
     * Cerca i contatti nella rubrica che hanno un nome o cognome che inizia con la stringa
     * di ricerca fornita, ignorando la distinzione tra maiuscole e minuscole.
     * 
     * @param s La stringa di ricerca, che può essere parte del nome o cognome.
     * @return Una lista di contatti che corrispondono alla ricerca.
     */
    public ObservableList<Contatto> cercaContatto(String s){
        ObservableList<Contatto> results = FXCollections.observableArrayList();
        for (Contatto contatto : contatti){
            if (contatto.getNome().toLowerCase().startsWith(s.toLowerCase()) ||
                contatto.getCognome().toLowerCase().startsWith(s.toLowerCase())) {
                results.add(contatto);
            }
        }
        return results;
    }

    /**
     * Ordina i contatti nella rubrica prima per cognome e poi per nome, in ordine alfabetico,
     * ignorando la distinzione tra maiuscole e minuscole.
     */
    private void ordinaContatti(){
        contatti.sort((c1, c2) -> {
            int cognomeComp = c1.getCognome().compareToIgnoreCase(c2.getCognome());
            if (cognomeComp != 0) {
                return cognomeComp;
            }
            return c1.getNome().compareToIgnoreCase(c2.getNome());
        });
    }

    /**
     * Restituisce la lista dei contatti presenti nella rubrica.
     * 
     * @return Una lista osservabile dei contatti nella rubrica.
     */
    public ObservableList<Contatto> getContatti(){
        return contatti;
    }
}
