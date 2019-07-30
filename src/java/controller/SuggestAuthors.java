/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Autori;
import model.AutoriFactory;
import utils.AuthorTokenizer;


/**
 *
 * @author pc
 */
@WebServlet(name = "SuggestAuthors", urlPatterns = {"/suggest.json"})
public class SuggestAuthors extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        AutoriFactory factory = AutoriFactory.getInstance();
        
        List<AuthorTokenizer> authors = new ArrayList<>();
        
        String command = request.getParameter("cmd");

        if (command != null){
           if (command.equals("author")) {

                String toSearch = request.getParameter("toSearch");
                

               List<Autori> autoriFound = factory.searchAutori(toSearch);
               for (Autori a : autoriFound) {
                    AuthorTokenizer b = new AuthorTokenizer(a.getNome(), a.getCognome(), a.getId());
                    authors.add(b);
               }
                request.setAttribute("autoriList", authors);

                response.setContentType("application/json");

                request.getRequestDispatcher("autoreFoundJSON.jsp").forward(request, response);

           }
        }
        
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SuggestAuthors.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(SuggestAuthors.class.getName()).log(Level.SEVERE, null, ex);
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

