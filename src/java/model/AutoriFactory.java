/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AutoriFactory {

    private static AutoriFactory singleton;

    public AutoriFactory() {

    }

    public static AutoriFactory getInstance() {
        if (singleton == null) {
            singleton = new AutoriFactory();
        }

        return singleton;
    }

    public List<Autori> getAutori() {
        List<Autori> autori = new ArrayList<>();
        /*
        Milestone 2:
        Autori giovanni = new Autori();
        giovanni.setId(1);
        giovanni.setNome("Giovanni");
        giovanni.setCognome("Muchacha");
        giovanni.setEmail("muchacha@gmail.com");
        giovanni.setPassword("muchacha");
        autori.add(giovanni);
        
        Autori giampiero = new Autori();
        giampiero.setId(2);
        giampiero.setNome("Giampiero");
        giampiero.setCognome("Beccarini");
        giampiero.setEmail("becca@gmail.com");
        giampiero.setPassword("pierino");
        autori.add(giampiero);
         */

        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from autori";
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Autori autore = new Autori();
                autore.setId(set.getInt("id"));
                autore.setNome(set.getString("nome"));
                autore.setCognome(set.getString("cognome"));
                autore.setEmail(set.getString("email"));
                autore.setPassword(set.getString("password"));
                autori.add(autore);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return autori;
    }

    public Autori getAutoreById(int id) {
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from autori where id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Autori autore = new Autori();
                autore.setId(set.getInt("id"));
                autore.setNome(set.getString("nome"));
                autore.setCognome(set.getString("cognome"));
                autore.setEmail(set.getString("email"));
                autore.setPassword(set.getString("password"));
                stmt.close();
                conn.close();
                return autore;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Autori getAutoreByNomeCognome(String nome, String cognome) {
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from autori where nome = ? and cognome = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, cognome);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Autori autore = new Autori();
                autore.setId(set.getInt("id"));
                autore.setNome(set.getString("nome"));
                autore.setCognome(set.getString("cognome"));
                autore.setEmail(set.getString("email"));
                autore.setPassword(set.getString("password"));
                stmt.close();
                conn.close();
                return autore;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;
    }
    

    public Autori getAutoreByEmailPassword(String email, String password) {

        /*Vecchio metodo:
        List<Autori> autori = this.getAutori();
        for (Autori a : autori) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                return a;
            }
        }
        

        return null;
         */
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from autori where email = ? and password = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Autori autore = new Autori();
                autore.setId(set.getInt("id"));
                autore.setNome(set.getString("nome"));
                autore.setCognome(set.getString("cognome"));
                autore.setEmail(set.getString("email"));
                autore.setPassword(set.getString("password"));
                stmt.close();
                conn.close();
                return autore;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void CancellaAutore(int id) throws SQLException, ParseException {
        Autori autore = new AutoriFactory().getAutoreById(id);
        List<Articoli> articoli = new ArticoliFactory().getArticoliByAutori(autore);
        Connection conn=null;
        try {
            conn = DbManager.getInstance().getDbConnection();
            conn.setAutoCommit(false);
            
            String rm_registro = "delete from registro where autore_id=?";
            PreparedStatement removeRegistro = conn.prepareStatement(rm_registro);
            removeRegistro.setInt(1, autore.getId());
            removeRegistro.executeUpdate();
            
            for (Articoli art : articoli) {
                art.removeAutore(autore);
                
                if (art.getAutore().size()==0) {
                    String rm_articolo = "delete from articoli where id=?";
                    PreparedStatement removePost = conn.prepareStatement(rm_articolo);
                    removePost.setInt(1, art.getId());
                    removePost.executeUpdate();
                }
            }
            
            String rm_autore = "delete from autori where id=?";
            PreparedStatement removeAutore = conn.prepareStatement(rm_autore);
            removeAutore.setInt(1, id);
            removeAutore.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(AutoriFactory.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public List<Autori> searchAutori(String toSearch) throws ParseException{
        
        List<Autori> listToReturn = new ArrayList<>();

        for (Autori autore : getAutori()){
            if (autore.getNome().contains(toSearch) || autore.getCognome().contains(toSearch)) {
                if (!(listToReturn.contains(autore)))
                     listToReturn.add(autore);
                
            }
            
            
        }

        return listToReturn;
    }
    
}

