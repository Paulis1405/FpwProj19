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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class OrganizzatoriFactory {
    private static OrganizzatoriFactory singleton;
    
    private OrganizzatoriFactory(){
    
    }
    
    public static OrganizzatoriFactory getInstance(){
        if(singleton == null){
            singleton = new OrganizzatoriFactory();
        }
        
        return singleton;
    }
    
    public List<Organizzatori> getOrganizzatori(){
        List<Organizzatori> organizzatori = new ArrayList<>();
        
try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from organizzatori";
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Organizzatori organizzatore = new Organizzatori();
                organizzatore.setId(set.getInt("id"));
                organizzatore.setNome(set.getString("nome"));
                organizzatore.setCognome(set.getString("cognome"));
                organizzatore.setEmail(set.getString("email"));
                organizzatore.setPassword(set.getString("password"));
                organizzatori.add(organizzatore);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }        
        return organizzatori;
    }
    
    public Organizzatori getOrganizzatoreById(int id){
        List<Organizzatori> organizzatori = this.getOrganizzatori();
        for(Organizzatori a : organizzatori){
            if(a.getId() == id){
                return a;
            }
        }
        
        return null;
    }
    
    public Organizzatori getOrganizzatoreByEmailPassword(String email, String password){
        /* Vecchio metodo:
        List<Organizzatori> organizzatori = this.getOrganizzatori();
        for(Organizzatori a : organizzatori){
            if(a.getEmail().equals(email) && a.getPassword().equals(password)){
                return a;
            }
        }
        */
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from organizzatori where email = ? and password = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Organizzatori organizzatore = new Organizzatori();
                organizzatore.setId(set.getInt("id"));
                organizzatore.setNome(set.getString("nome"));
                organizzatore.setCognome(set.getString("cognome"));
                organizzatore.setEmail(set.getString("email"));
                organizzatore.setPassword(set.getString("password"));
                stmt.close();
                conn.close();
                
                return organizzatore;
            } 
            else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoriFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
}


