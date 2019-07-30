/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

/**
 *
 * 
 */
public class ArticoliFactory {
    private static ArticoliFactory singleton;
    
    private ArticoliFactory(){
        
    }
    
    public static ArticoliFactory getInstance(){
        if(singleton == null){
            singleton = new ArticoliFactory();
        }
        
        return singleton;
    }
    
    public List<Articoli> getArticoli(){
        List<Articoli> articoli = new ArrayList<>();
        
        Articoli dc = new Articoli();
        dc.setId(1);
        dc.setTitolo("Divina Commedia");
        dc.setTesto("Nel mezzo del cammin di nostra vita...");
        Autori dante = AutoriFactory.getInstance().getAutoreById(1);
        dc.getAutore().add(dante);
        articoli.add(dc);
        
        Articoli vn = new Articoli();
        vn.setId(2);
        vn.setTitolo("Vita Nova");
        vn.setTesto("Tanto bella e tanto onesta pare");
        vn.getAutore().add(dante);
        articoli.add(vn);
        
        Articoli ps = new Articoli();
        ps.setId(3);
        ps.setTitolo("I Promessi Sposi");
        ps.setTesto("Quel ramo del lago di Como...");
        Autori manzoni = AutoriFactory.getInstance().getAutoreById(2);
        ps.getAutore().add(manzoni);
        articoli.add(ps);
        
        return articoli;
    }
    
    public List<Articoli> getArticoliByAutori(Autori a){
        List<Articoli> articoliAutori = new ArrayList<>();
        List<Articoli> tuttiArticoli = this.getArticoli();
        
        for(Articoli l : tuttiArticoli){
            for(Autori a1 : l.getAutore()){
                if(a1.equals(a)){
                    articoliAutori.add(l);
                }
            }
        }
        
        return articoliAutori;
    }
    
    public Articoli getArticoliById(int id){
        List<Articoli> tuttiArticoli = this.getArticoli();
        for(Articoli l : tuttiArticoli){
            if(l.getId() == id){
                return l;
            }
        } 
        return null;
    }
    
    public List<Articoli> getArticoliByCategorie(String categoria){
        List<Articoli> articoliCategorie = new ArrayList<>();
        List<Articoli> tuttiArticoli = this.getArticoli();
        
        for(Articoli l : tuttiArticoli){
                if(categoria.equals(l.getCategorie())){
                    articoliCategorie.add(l);
                }
        }
        return articoliCategorie;
    }
    
    public Articoli getArticoliByTitolo(String titolo){
        List<Articoli> tuttiArticoli = this.getArticoli();
        for (Articoli l : tuttiArticoli) {
            if ((l.getTitolo()).equalsIgnoreCase(titolo)) {
                return l;
            }
        }
        return null;
    }   
}
