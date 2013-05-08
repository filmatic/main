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
public class AskToRentServlet extends HttpServlet {

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
            
            String movieToRent = (String) request.getParameter("movieToRent");
            
            Customer customer = (Customer) request.getSession().getAttribute("customer");
            Integer customerId = customer.getCustomerId();
            Accounttype accountType = customer.getAccountType();
            
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String currentTime = sdf.format(dt);
            
            Orders newOrder = new Orders();
            
            Movie movie = filmaticBean.getMovie(Integer.parseInt(movieToRent));
            boolean available = filmaticBean.checkAvailability(movie);
            
            if (available) {
                if (accountType.getAccountType() == 1) {
                    if (filmaticBean.checkCustomerLimit(customerId) < 1) {
                        String nextSlot = filmaticBean.getNextOrdersId() + "";
                        newOrder.setOrderId(Integer.parseInt(nextSlot));
                        newOrder.setCurrentlyOut(0);
                        newOrder.setCustomerId(customer);
                        newOrder.setMovieId(movie);
                        newOrder.setPending(1);
                        newOrder.setDateTime(currentTime);
                        
                        filmaticBean.save(newOrder);
                        RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                        rd.forward(request, response);
                        
                        
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (accountType.getAccountType() == 2) {
                    if (filmaticBean.checkCustomerLimit(customerId) < 1) {
                        String nextSlot = filmaticBean.getNextOrdersId() + "";
                        newOrder.setOrderId(Integer.parseInt(nextSlot));
                        newOrder.setCurrentlyOut(0);
                        newOrder.setCustomerId(customer);
                        newOrder.setMovieId(movie);
                        newOrder.setPending(1);
                        newOrder.setDateTime(currentTime);
                        
                        filmaticBean.save(newOrder);
                        RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                        rd.forward(request, response);
                        
                        
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (accountType.getAccountType() == 3) {
                    if (filmaticBean.checkCustomerLimit(customerId) < 2) {
                        String nextSlot = filmaticBean.getNextOrdersId() + "";
                        newOrder.setOrderId(Integer.parseInt(nextSlot));
                        newOrder.setCurrentlyOut(0);
                        newOrder.setCustomerId(customer);
                        newOrder.setMovieId(movie);
                        newOrder.setPending(1);
                        newOrder.setDateTime(currentTime);
                        
                        filmaticBean.save(newOrder);
                        RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (accountType.getAccountType() == 4) {
                    String nextSlot = filmaticBean.getNextOrdersId() + "";
                    newOrder.setOrderId(Integer.parseInt(nextSlot));
                    newOrder.setCurrentlyOut(0);
                    newOrder.setCustomerId(customer);
                    newOrder.setMovieId(movie);
                    newOrder.setPending(1);
                    newOrder.setDateTime(currentTime);
                    
                    filmaticBean.save(newOrder);
                    RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("customer_queue.jsp");
                rd.forward(request, response);
            }
            
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
