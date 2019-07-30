/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArticoliFactory {

    private static ArticoliFactory singleton;

    public ArticoliFactory() {

    }

    public static ArticoliFactory getInstance() {
        if (singleton == null) {
            singleton = new ArticoliFactory();
        }

        return singleton;
    }

    public List<Articoli> getArticoli() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-mm-dd");
        List<Articoli> articoli = new ArrayList<>();
        List<Autori> autori = new ArrayList<>();

        try {
            Boolean loggedIn;
            Connection conn = DbManager.getInstance().getDbConnection();

            String sql = "select * from articoli";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet set = stmt.executeQuery();
            
            loggedIn = set.first(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                do {
                    Articoli articolo = new Articoli();
                    articolo.setId(set.getInt("id"));
                    articolo.setTitolo(set.getString("titolo"));
                    String sql1 = "select autore_id"
                            + " from registro "
                            + "where articolo_id = ?";
                    PreparedStatement stmt1 = conn.prepareStatement(sql1);
                    int articolo_id = set.getInt("id");
                    stmt1.setInt(1, articolo_id);

                    ResultSet set1 = stmt1.executeQuery();
                    while (set1.next()) {
                        Autori aut = AutoriFactory.getInstance().getAutoreById(set1.getInt("autore_id"));

                        articolo.addAutore(aut);
                    }
                    stmt1.close();
                    

                    articolo.setData(set.getDate("data_articolo"));
                    articolo.setTesto(set.getString("testo"));
                    articolo.setCategorie(set.getString("categorie"));
                    articolo.setStato(set.getString("stato"));
                    articoli.add(articolo);

                } while (set.next());
                stmt.close();
                conn.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return articoli;
    }

    public List<Articoli> getArticoliDaValutare(Autori a) throws ParseException {
        List<Articoli> articoliAutori = new ArrayList<>();
        List<Articoli> tuttiArticoli = this.getArticoli();
        for (Articoli l : tuttiArticoli) {
            List<Autori> aut = new ArrayList<>(l.getAutore());

            for (Autori a1 : aut) {
                if ((l.getStato()).equals("Da Valutare") && a1.equals(a)) {
                    articoliAutori.add(l);
                }
            }
        }
        return articoliAutori;
    }

    public List<Articoli> getArticoliOrdinati() throws ParseException {
        List<Articoli> a = this.getArticoli();
        Collections.sort(a, new DateComparable());

        return a;
    }

    public List<Articoli> getArticoliByAutori(Autori a) throws ParseException {
        List<Articoli> articoliAutori = new ArrayList<>();
        List<Articoli> tuttiArticoli = this.getArticoliOrdinati();

        for (Articoli l : tuttiArticoli) {
            for (Autori a1 : l.getAutore()) {
                if (a1.equals(a)) {
                    articoliAutori.add(l);
                }
            }
        }

        return articoliAutori;
    }

    public Articoli getArticoliById(int id) throws ParseException {
        List<Articoli> tuttiArticoli = this.getArticoliOrdinati();
        for (Articoli l : tuttiArticoli) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public List<Articoli> getArticoliByCategorie(String categoria) throws ParseException {
        List<Articoli> articoliCategorie = new ArrayList<>();
        List<Articoli> tuttiArticoli = this.getArticoliOrdinati();

        for (Articoli l : tuttiArticoli) {
            if (categoria.equals(l.getCategorie())) {
                articoliCategorie.add(l);
            }
        }
        return articoliCategorie;
    }

    public Articoli getArticoliByTitolo(String titolo) throws ParseException {
        List<Articoli> tuttiArticoli = this.getArticoliOrdinati();
        for (Articoli l : tuttiArticoli) {
            if ((l.getTitolo()).equalsIgnoreCase(titolo)) {
                return l;
            }
        }
        return null;
    }

    public static int CreaArticolo() {
        int pid = 0;
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Boolean loggedIn;
            String sql = "insert into articoli "
                    + "(id, titolo, data_articolo, testo, categorie) "
                    + "values "
                    + "(default, 'Titolo', '2019-01-01', 'Vuoto', null) ";

            PreparedStatement stmt = conn.prepareStatement(sql);

            int rows = stmt.executeUpdate();
            System.out.println("Sono state aggiunte " + rows + " righe");

            sql = "select id from articoli order by id desc limit 0,1 ";
            stmt = conn.prepareStatement(sql);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.first(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                pid = set.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return pid;
    }

    public static void ModificaArticolo(int pid, String titolo, String testo, String categorie, List<Autori> autori, String data) throws ParseException {
        try {
            Articoli articolo = new ArticoliFactory().getArticoliById(pid);
            
                Connection conn = DbManager.getInstance().getDbConnection();
                Boolean loggedIn;

                String sql = "update articoli set "
                        + "titolo = ?, data_articolo = ?, testo = ?, categorie = ?, stato = 'Aperto' "
                        + "where id = ?";

                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, titolo);
                stmt.setString(2, data);
                stmt.setString(3, testo);
                stmt.setString(4, categorie);
                stmt.setInt(5, pid);

                int rows = stmt.executeUpdate();
                System.out.println("Sono state modificate " + rows + " righe");
                if (autori != null) {
                    for (Autori a : autori) {
                        boolean presente;
                        String sql4 = "select * from autori "
                                + "where nome = ? and cognome = ?";
                        /*Rendere rigido il controllo per l'autore*/
                        stmt = conn.prepareStatement(sql4);

                        stmt.setString(1, a.getNome());
                        stmt.setString(2, a.getCognome());

                        ResultSet set = stmt.executeQuery();
                        presente=set.first();
                        if (presente) {
                             Autori autore = new AutoriFactory().getAutoreByNomeCognome(a.getNome(), a.getCognome());
                        String sql2 = "select valutatore_id, valutazione_id from registro where articolo_id = ? ";
                        stmt = conn.prepareStatement(sql2);

                        stmt.setInt(1, pid);
                        set = stmt.executeQuery();
                
                        loggedIn = set.first(); // Controllo se c'è almeno una riga
                        if (loggedIn) {
                            int valutatore_id = set.getInt("valutatore_id");
                            int valutazione_id = set.getInt("valutazione_id");
                            
                            String sql3 = "insert into registro "
                                    + "(articolo_id, autore_id, valutatore_id, valutazione_id) "
                                    + "values "
                                    + "(" + pid + "," + autore.getId() + "," + valutatore_id + ","+ valutazione_id+")";

                            stmt = conn.prepareStatement(sql3);
                            rows = stmt.executeUpdate();
                        }
                        else {
                            String sql3 = "insert into registro "
                                    + "(articolo_id, autore_id, valutatore_id, valutazione_id) "
                                    + "values "
                                    + "(" + pid + "," + autore.getId() + "," + (int)(Math.random()*2+1) + ", default)";

                            stmt = conn.prepareStatement(sql3);
                            rows = stmt.executeUpdate();
                        }
                        }
                        stmt.close();
                        conn.close();
                    }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
    
    
}
