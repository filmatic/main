/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import sessionBean.filmaticSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author Jonathan
 */
public class GenerateAllMovieServlet extends HttpServlet {

    @EJB filmaticSessionBean filmaticBean; 
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            Person person = (Person) request.getSession().getAttribute("person");
            
            Movie[] movies = filmaticBean.getAllMovies();//getAllMoviesNotInQueue(person);
            
            
            // SORT BY TIMES RENTED
            for (int i=0;i<movies.length-1;i++) {
                for (int j=i+1;j<movies.length;j++) {
                    if (movies[i].getTimesRented()<movies[j].getTimesRented()) {
                        // SWAP
                        Movie temp = movies[i];
                        movies[i] = movies[j];
                        movies[j] = temp;
                    }
                }
            }
            
            
            request.getSession().setAttribute("movieList", movies);
            
            Movie[] empty = null;
            request.getSession().setAttribute("searchResults", empty);
            
            RequestDispatcher rd = request.getRequestDispatcher("customer_movies.jsp");
            rd.forward(request, response);
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
