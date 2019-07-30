/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * 
 */
public class Articoli {
    private int id;
    private String titolo;
    private List<Autori> autore;
    private Date data;
    private String immagine;
    private String testo;
    private String categorie;
    private String stato;

    public Articoli() {
        this.autore = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Autori> getAutore() {
        return autore;
    }
    public void addAutore(Autori autore) {
        boolean contains=false;
        for (Autori t : this.autore) {
            if (t.equals(autore))
                contains=true;
        }
        if (!contains)
             this.autore.add(autore);
    }
    
    public void removeAutore (Autori autore) {
        List<Autori> autori = new ArrayList<>();
        for (Autori a : this.getAutore())
            if (!(a.equals(autore)))
                autori.add(a);
        this.autore=autori;
                
    }
    
    public void setAutore(List<Autori> autore) {
        this.autore = autore;
    }

    public Date getData() {
        return data;
    }
    
    public String getDataString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy/MM/dd");
        String data = sdf.format(this.data);
        return data;
    }
    
    public void setDataString(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        this.data = sdf.parse(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    
    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

  
    
}
