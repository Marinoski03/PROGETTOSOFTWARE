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
public class Contatto implements Comparable<Contatto>{
    
    private StringProperty nome;
    private StringProperty cognome;
    private List<StringProperty> numeri;
    private List<StringProperty> email;
    
    
    public Contatto(StringProperty nome, StringProperty cognome){
        this.nome=nome;
        this.cognome=cognome;
        numeri=new ArrayList<>();
        email=new ArrayList<>();
    }
    
    public void aggiungiNumero(StringProperty numero){
        
        numeri.add(numero);
        
    }
    
    public void aggiungiEmail(StringProperty email){
        
        this.email.add(email);
        
    }
    
    @Override
    public String toString(){
        
      StringBuffer bf1=new StringBuffer();
      StringBuffer bf2=new StringBuffer();
      
      for(StringProperty n:numeri){
          bf1.append(n);
      }
      for(StringProperty e:email){
          bf2.append(e);
      }
        return "Nome: "+nome+" Cognome: "+cognome+" Numeri di telefono: "+bf1.toString()+" Email: "+bf2.toString();
    }
    
  @Override
public int compareTo(Contatto c) {
  
    String thisCognome = this.cognome.get();
    String otherCognome = c.cognome.get();
    String thisNome = this.nome.get();
    String otherNome = c.nome.get();

    if (thisCognome == null || otherCognome == null) {
        return thisNome.compareTo(otherNome);
    }

    if (thisCognome.equals(otherCognome)) {
        return thisNome.compareTo(otherNome);
    }

    return thisCognome.compareTo(otherCognome);
}

    
}
