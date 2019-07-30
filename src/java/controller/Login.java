/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Autori;
import model.AutoriFactory;
import model.Organizzatori;
import model.OrganizzatoriFactory;
import java.text.ParseException;


/**
 *
 *
 */

@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

    /*
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
        
        HttpSession sessione = request.getSession();
        if(request.getParameter("accesso") != null){
            // Tentativo login
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            Autori autore = AutoriFactory.getInstance()
                    .getAutoreByEmailPassword(email, password);
            
            Organizzatori organizzatore = OrganizzatoriFactory.getInstance()
                    .getOrganizzatoreByEmailPassword(email, password);
            
            if(autore != null){
                sessione.setAttribute("autoreId", autore.getId()); //sessione
            }
            else if(organizzatore != null) {
                sessione.setAttribute("organizzatoreId", organizzatore.getId()); //sessione*/
            }
        
        }
        if(sessione.getAttribute("autoreId") != null){
           
            // caricamento jsp
            request.getRequestDispatcher("articoli.html")
                    .forward(request, response);
        }
        else if(sessione.getAttribute("organizzatoreId") != null){
            
            
             request.getRequestDispatcher("gestione.html")
                    .forward(request, response);
        }
        else{
            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
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
   