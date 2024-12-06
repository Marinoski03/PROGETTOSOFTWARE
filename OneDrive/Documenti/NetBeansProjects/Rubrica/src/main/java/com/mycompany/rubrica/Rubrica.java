/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubrica;

import java.util.TreeSet;
import javafx.collections.ObservableList;

/**
 *
 * @author obbiv
 */
public class Rubrica {
     private TreeSet<Contatto> contatti;
    
    public Rubrica(){
        
        contatti=new TreeSet<>();
        
    }
    
    public void aggiungiContatto(Contatto c){
        
        contatti.add(c);
        
    }
    
    public void modificaContatto(Contatto c){
        
        
        
    }
    
    public void eliminaContatto(Contatto c){
        
        
        
    }
    
    public ObservableList<Contatto> cercaContatto(String s){
        
        
        
    }
    
}
