/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.StringProperty;


/**
 *
 * @author obbiv
 */

/**
 * La classe {@code Contatto} rappresenta un contatto nella rubrica, contenente
 * il nome, cognome, numeri di telefono ed email.
 * Implementa l'interfaccia {@link Comparable} per permettere il confronto tra
 * i contatti, basato prima sul cognome e poi sul nome.
 * 
 * @author obbiv
 */

public class Contatto {
    
    private String nome; //Proprietà per il nome del contatto
    private String cognome; //Proprietà per il cognome del contatto
    private List<String> numeri; //Lista di stringhe del contatto
    private List<String> email; //Lista di email del contatto
    
    /**
     * Costruttore per creare un nuovo contatto con nome e cognome.
     * 
     * @param nome il nome del contatto
     * @param cognome il cognome del contatto
     */
    
    public Contatto(String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
        numeri=new ArrayList<>(); //Lista vuota per i numeri di telefono
        email=new ArrayList<>();  //Lista vuota per le email
    }
    
    /**
     * Aggiunge un numero di telefono alla lista dei numeri del contatto.
     * 
     * @param numero il numero di telefono da aggiungere
     */
    
    public void aggiungiNumero(String numero){
        
        if(this.numeri.size()<3)
        numeri.add(numero);
        //implementare Runtime exception
    }
    
    public String getNome(){
        
        return nome;
        
    }
    
    public String getCognome(){
        
        return cognome;
        
    }
    
    public List<String> getNumeri(){
        
        return numeri;
        
    }
    
    
    public List<String> getEmail(){
        
        return email;
        
    }
   
    public void setNome(String nome){
        
        this.nome=nome;
        
    }
    
    public void setCognome(String cognome){
        
        this.cognome=cognome;
        
    }
    
    public void rimuoviNumero(String numero){
        
        this.numeri.remove(numero);
        
    }
    
    public void rimuoviEmail(String email){
        
        this.email.remove(email);
        
    }
    
     /**
     * Aggiunge un'email alla lista delle email del contatto.
     * 
     * @param email l'email da aggiungere
     */
    
    public void aggiungiEmail(String email){
        if(this.email.size()<3)
        this.email.add(email);
        //implementare Runtime exception
    }
    
     /**
     * Restituisce una rappresentazione in formato stringa del contatto,
     * mostrando nome, cognome, numeri di telefono ed email.
     * 
     * @return una stringa che rappresenta il contatto
     */
    
    @Override
    public String toString(){
        
      StringBuffer bf1=new StringBuffer(); //Buffer per numeri
      StringBuffer bf2=new StringBuffer(); //Buffer per email
      
      for(String n:numeri){ //Aggiunge numeri al buffer
          bf1.append(n);
      }
      for(String e:email){ //Aggiunge le email al buffer
          bf2.append(e);
      }
        return "Nome: "+nome+" Cognome: "+cognome+" Numeri di telefono: "+bf1.toString()+" Email: "+bf2.toString(); //Restituisce una stringa formattata
    }
    
     /**
     * Confronta due contatti in base al cognome e al nome.
     * Se i cognomi sono uguali, il confronto avviene sul nome.
     * 
     * @param c il contatto con cui confrontare
     * @return un numero negativo se il contatto corrente è "minore",
     *         zero se sono uguali, positivo se è "maggiore"
     */
    
}
