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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Articoli;
import model.ArticoliFactory;
import model.Autori;
import model.AutoriFactory;
import utils.AuthorTokenizer;

@WebServlet(name = "WritePaper", urlPatterns = {"/scriviArticolo.html"})
public class WritePaper extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        
        if (session.getAttribute("autoreId") == null) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        if (request.getParameter("new_art") != null) {
            int pid = ArticoliFactory.CreaArticolo();
            Articoli l = ArticoliFactory.getInstance().getArticoliById(pid);
            session.setAttribute("articolo", l);
            request.setAttribute("pid", pid);
            request.getRequestDispatcher("scriviArticolo.jsp")
                    .forward(request, response); 
        }
        if (request.getParameter("pid") != null) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            Articoli l = ArticoliFactory.getInstance().getArticoliById(pid);
            List<Autori> authors = new ArrayList<>();
            
            
            
            if (request.getParameter("addAuthor") != null) {
                String author = "";
                if (request.getParameter("author").length() > 0)
                    author=request.getParameter("author") ;
                
                
                if (author != "") {
                    AuthorTokenizer autor = new AuthorTokenizer(author);
                    
                    Autori a = new Autori();
                    /*a.setNome(author.split(" ")[0]);
                    a.setCognome(author.split(" ")[1]);*/
                    a.setNome(autor.getName());
                    a.setCognome(autor.getSurname());
                    a.setId(autor.getId());
                    List<Autori> aut = new ArrayList<>();
                    authors.add(a);
                    l.addAutore(a);
                }
            }
            
            if (request.getParameter("salvataggio") != null) {
           
                String titolo = request.getParameter("tit");
                String testo = request.getParameter("testo");
                String categorie = request.getParameter("categorie");
                
                String data = l.getDataString();
                if (request.getParameter("data").length() > 0)
                    data=request.getParameter("data");
                
                
                if (categorie != null) l.setCategorie(categorie);
                l.setDataString(data);
                l.setTitolo(titolo);
                l.setTesto(testo);
                session.setAttribute("articolo", l);
            request.setAttribute("pid", pid);
                ArticoliFactory.ModificaArticolo(pid, titolo, testo, categorie, authors, data);
                
            }
            
                session.setAttribute("articolo", l);
            request.setAttribute("pid", pid);
            
            
            
        } else {
            int autoreId = (int) session.getAttribute("autoreId");
            Autori autore = AutoriFactory.getInstance()
                    .getAutoreById(autoreId);
            session.setAttribute("autore", autore);
        }
        
        request.getRequestDispatcher("scriviArticolo.jsp")
                    .forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException e) {
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
        } catch (ParseException e) {
            System.out.println("Sto gestendo ParseException");
        }
    }

}
