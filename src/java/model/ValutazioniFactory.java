/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * 
 */
public class ValutazioniFactory {
    
    private static ValutazioniFactory singleton;
    
    private ValutazioniFactory() {
        
    }
    
    public static ValutazioniFactory getInstance(){
        if(singleton == null){
            singleton = new ValutazioniFactory();
        }
        
        return singleton;
    }
    
    public List<Valutazioni> getValutazioni() throws ParseException{

        List<Valutazioni> valutazioni = new ArrayList<>();
        
        Valutazioni vl = new Valutazioni();
        vl.setId(1);
        vl.setVoto(4);
        vl.setComm_autori("Complimenti");
        vl.setComm_organizzatori("Si può far meglio");
        Articoli artl = ArticoliFactory.getInstance().getArticoliById(1);
        vl.setArticolo(artl);
        valutazioni.add(vl);
        
        Valutazioni vm = new Valutazioni();
        vm.setId(2);
        vm.setVoto(4);
        vm.setComm_autori("Da migliorare");
        vm.setComm_organizzatori("Va bene, solo qualcosa da rivedere");
        Articoli art2 = ArticoliFactory.getInstance().getArticoliById(2);
        vl.setArticolo(art2);
        valutazioni.add(vm);
        
        Valutazioni vn = new Valutazioni();
        vl.setId(3);
        vl.setVoto(2);
        vl.setComm_autori("Non va bene per me !");
        vl.setComm_organizzatori("Ritenti per un buon articolo");
        Articoli art3 = ArticoliFactory.getInstance().getArticoliById(3);
        vl.setArticolo(art3);
        valutazioni.add(vn);
        
        return valutazioni;
    }
    public List<Valutazioni> getValutazioniArticolo(Articoli a) throws ParseException {
        List<Valutazioni> valutazioniAutore = new ArrayList<>();
        List<Valutazioni> tutteValutazioni = this.getValutazioni();
            for(Valutazioni l : tutteValutazioni){
                   if(a.equals(l.getArticolo())){
                       valutazioniAutore.add(l);
                   }
            }
            return valutazioniAutore;
    }
        
    public Valutazioni getValutazioniId(int id) throws ParseException{
        List<Valutazioni> tutteValutazioni = this.getValutazioni();
        for(Valutazioni l : tutteValutazioni){
            if(l.getId() == id){
                return l;
            }
        }
        
        return null;
    }
    
    public List<Valutazioni> getValutazioniByVoto(int v) throws ParseException{
        List<Valutazioni> valutazioniAutore = new ArrayList<>();
        List<Valutazioni> tutteValutazioni = this.getValutazioni();
            for(Valutazioni l : tutteValutazioni){
                   if(v == l.getVoto()){
                       valutazioniAutore.add(l);
                   }
            }
            return valutazioniAutore;
    }
}
