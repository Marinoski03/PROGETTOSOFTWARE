/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.StringProperty;

/**
 * Classe che rappresenta un contatto all'interno della rubrica.
 * Ogni contatto è identificato da un nome e un cognome, e può avere una lista di numeri di telefono
 * e una lista di indirizzi email. 
 * La classe fornisce metodi per aggiungere, rimuovere e ottenere numeri e email.
 * Inoltre, offre un metodo per visualizzare una rappresentazione in formato stringa del contatto.
 * 
 * @author obbiv
 */
public class Contatto {

    // Variabili di istanza
    private String nome;
    private String cognome; 
    private List<String> numeri; 
    private List<String> email; 
    
    
    public Contatto(){
    }

    /**
     * Costruttore della classe Contatto.
     * Inizializza un contatto con un nome e un cognome specificati,
     * e crea liste vuote per numeri di telefono e indirizzi email.
     * 
     * @param nome Il nome del contatto.
     * @param cognome Il cognome del contatto.
     */
    public Contatto(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
        numeri = new ArrayList<>(); 
        email = new ArrayList<>();  
    }

    /**
     * Aggiunge un numero di telefono alla lista dei numeri del contatto.
     * Un contatto può avere al massimo 3 numeri di telefono.
     * 
     * @param numero Il numero di telefono da aggiungere.
     */
    public void aggiungiNumero(String numero){
        if (this.numeri.size() < 3)
            numeri.add(numero);
    }

    /**
     * Restituisce il nome del contatto.
     * 
     * @return Il nome del contatto.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Restituisce il cognome del contatto.
     * 
     * @return Il cognome del contatto.
     */
    public String getCognome(){
        return cognome;
    }

    /**
     * Restituisce la lista dei numeri di telefono del contatto.
     * 
     * @return La lista dei numeri di telefono.
     */
    public List<String> getNumeri(){
        return numeri;
    }

    /**
     * Restituisce la lista degli indirizzi email del contatto.
     * 
     * @return La lista degli indirizzi email.
     */
    public List<String> getEmail(){
        return email;
    }

    /**
     * Imposta il nome del contatto.
     * 
     * @param nome Il nome da assegnare al contatto.
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Imposta il cognome del contatto.
     * 
     * @param cognome Il cognome da assegnare al contatto.
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    /**
     * Rimuove un numero di telefono dalla lista dei numeri del contatto.
     * 
     * @param numero Il numero di telefono da rimuovere.
     */
    public void rimuoviNumero(String numero){
        this.numeri.remove(numero);
    }

    /**
     * Rimuove un indirizzo email dalla lista degli indirizzi email del contatto.
     * 
     * @param email L'indirizzo email da rimuovere.
     */
    public void rimuoviEmail(String email){
        this.email.remove(email);
    }

    /**
     * Aggiunge un indirizzo email alla lista degli indirizzi email del contatto.
     * Un contatto può avere al massimo 3 indirizzi email.
     * 
     * @param email L'indirizzo email da aggiungere.
     */
    public void aggiungiEmail(String email){
        if (this.email.size() < 3)
            this.email.add(email);
    }

    /**
     * Restituisce una rappresentazione in formato stringa del contatto.
     * La stringa include il nome, cognome, numeri di telefono e indirizzi email del contatto.
     * 
     * @return La rappresentazione in formato stringa del contatto.
     */
    @Override
    public String toString(){
        StringBuffer bf1 = new StringBuffer();
        StringBuffer bf2 = new StringBuffer(); 
        
        for (String n : numeri){ 
            bf1.append(n);
        }
        for (String e : email){ 
            bf2.append(e);
        }
        return "Nome: " + nome + " Cognome: " + cognome + " Numeri di telefono: " + bf1.toString() + " Email: " + bf2.toString(); 
    }
}
