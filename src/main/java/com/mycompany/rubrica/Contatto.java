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

public class Contatto implements Comparable<Contatto>{
    
    private StringProperty nome; //Proprietà per il nome del contatto
    private StringProperty cognome; //Proprietà per il cognome del contatto
    private List<StringProperty> numeri; //Lista di stringhe del contatto
    private List<StringProperty> email; //Lista di email del contatto
    
    /**
     * Costruttore per creare un nuovo contatto con nome e cognome.
     * 
     * @param nome il nome del contatto
     * @param cognome il cognome del contatto
     */
    
    public Contatto(StringProperty nome, StringProperty cognome){
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
    
    public void aggiungiNumero(StringProperty numero){
        
        numeri.add(numero);
        
    }
    
     /**
     * Aggiunge un'email alla lista delle email del contatto.
     * 
     * @param email l'email da aggiungere
     */
    
    public void aggiungiEmail(StringProperty email){
        
        this.email.add(email);
        
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
      
      for(StringProperty n:numeri){ //Aggiunge numeri al buffer
          bf1.append(n);
      }
      for(StringProperty e:email){ //Aggiunge le email al buffer
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
    
  @Override
public int compareTo(Contatto c) {
  
    String thisCognome = this.cognome.get(); //Ottiene il cognome del contatto corrente
    String otherCognome = c.cognome.get(); //Ottiene il cognome del contatto da comparare
    String thisNome = this.nome.get(); //Ottiene il nome del contatto corrente
    String otherNome = c.nome.get(); //Ottiene il nome del contatto da comparare

    if (thisCognome == null || otherCognome == null) { //Se uno dei cognomi è NULL, confronta i nomi
        return thisNome.compareTo(otherNome);
    }

    if (thisCognome.equals(otherCognome)) { //Compara i cognomi
        return thisNome.compareTo(otherNome); //Se i cognomi soni uguali, confronta i nomi
    }

    return thisCognome.compareTo(otherCognome); //Compara i cognomi
}

    
}
