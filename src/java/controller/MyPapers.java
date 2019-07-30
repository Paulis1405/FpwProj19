/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Autori;
import model.AutoriFactory;
import model.Articoli;
import model.ArticoliFactory;
import java.text.ParseException;

/**
 *
 * 
 */
@WebServlet(name = "MyPapers", urlPatterns = {"/articoli.html"})
public class MyPapers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session= request.getSession(false);
        if (session.getAttribute("autoreId") != null) {
            int autoreId = (int) session.getAttribute("autoreId");
            Autori autore = AutoriFactory.getInstance()
                    .getAutoreById(autoreId);
            List<Articoli> articoli = ArticoliFactory.getInstance()
                    .getArticoliByAutori(autore);
            session.setAttribute("articoli", articoli);
            List<Articoli> articoliDaValutare =ArticoliFactory.getInstance()
                    .getArticoliDaValutare(autore);
            
            
            session.setAttribute("autore", autore);
            session.setAttribute("articoliDaValutare", articoliDaValutare);
            
            request.getRequestDispatcher("articoli.jsp")
                    .forward(request, response);
        }
        else if (session.getAttribute("organizzatoreId") != null){
            request.getRequestDispatcher("errore.jsp")
                    .forward(request, response);
        }
        else {
            request.getRequestDispatcher("ospiti.jsp")
                    .forward(request, response);
        }
        /*
        
        // qui ho autoreId inizializzato se l'ho appena fatto
        // oppure se l'ho fatto a una richiesta precedente
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (ParseException e) {
            System.out.println("Sto gestendo ParseException");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (ParseException e) {
            System.out.println("Sto gestendo ParseException");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

