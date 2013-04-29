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
import javax.servlet.RequestDispatcher;
import sessionBean.filmaticSessionBean;
import javax.ejb.EJB;
/**
 *
 * @author Jonathan
 */
public class AddToQueueServlet extends HttpServlet {

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
            
            String movieIdTemp = (String) request.getParameter("movieToQueue");
            Integer movieId = Integer.parseInt(movieIdTemp);
            Person person = (Person) request.getSession().getAttribute("person");
            
            System.out.println("Here" + movieId);
            
            Movie movie = filmaticBean.getMovie(movieId);
            Integer personId = person.getPersonId();
            
            Moviequeue newQueueEntry = new Moviequeue();
            
            if ((movie != null) && (person.getPersonId() != null) && (filmaticBean.existsInQueue(person.getPersonId().toString(), movieId) == false)) {
                newQueueEntry.setMovieQueueId(filmaticBean.getMaxMovieId());
                newQueueEntry.setAccountNumber(person.getPersonId());
                newQueueEntry.setMovieId(movie.getMovieId());
                filmaticBean.save(newQueueEntry);
            }
            
            Moviequeue[] currentQueue = filmaticBean.getCurrentUserQueue(personId);
                
            Movie[] movieQueueList = new Movie[currentQueue.length];
            for (int i = 0; i < movieQueueList.length; i++) {
                movieQueueList[i] = filmaticBean.getMovie(currentQueue[i].getMovieId());
            }
                
            request.getSession().setAttribute("queueList", movieQueueList);
            
             RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
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
