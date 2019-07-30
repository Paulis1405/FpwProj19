/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * 
 */
public class Valutazioni {
    private int id;
    private Articoli articolo;
    private int voto;
    private String comm_autori;
    private String comm_organizzatori;

    public Valutazioni(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Articoli getArticolo() {
        return articolo;
    }

    public void setArticolo(Articoli articolo) {
        this.articolo = articolo;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getComm_autori() {
        return comm_autori;
    }

    public void setComm_autori(String comm_autori) {
        this.comm_autori = comm_autori;
    }

    public String getComm_organizzatori() {
        return comm_organizzatori;
    }

    public void setComm_organizzatori(String comm_organizzatori) {
        this.comm_organizzatori = comm_organizzatori;
    }
    
}
