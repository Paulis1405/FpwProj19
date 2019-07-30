/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class AutoriFactory {
    private static AutoriFactory singleton;
    
    private AutoriFactory(){
    
    }
    
    public static AutoriFactory getInstance(){
        if(singleton == null){
            singleton = new AutoriFactory();
        }
        
        return singleton;
    }
    
    public List<Autori> getAutori(){
        List<Autori> autori = new ArrayList<>();
        
        Autori dante = new Autori();
        dante.setId(1);
        dante.setNome("Dante");
        dante.setCognome("Alighieri");
        dante.setEmail("dante@gmail.com");
        dante.setPassword("Beatrice");
        autori.add(dante);
        
        Autori manzoni = new Autori();
        manzoni.setId(2);
        manzoni.setNome("Alessandro");
        manzoni.setCognome("Manzoni");
        manzoni.setEmail("manzoni@gmail.com");
        manzoni.setPassword("Monza");
        autori.add(manzoni);
        
        return autori;
    }
    
    public Autori getAutoreById(int id){
        List<Autori> autori = this.getAutori();
        for(Autori a : autori){
            if(a.getId() == id){
                return a;
            }
        }
        
        return null;
    }
    
    public Autori getAutoreByEmailPassword(String email, String password){
        List<Autori> autori = this.getAutori();
        for(Autori a : autori){
            if(a.getEmail().equals(email) && a.getPassword().equals(password)){
                return a;
            }
        }
        
        return null;
    }
}
