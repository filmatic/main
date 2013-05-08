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
public class ApproveMovieRentalServlet extends HttpServlet {

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
            
            // Get Employee dealing with transaction
            Employee employee = (Employee) request.getAttribute("employee");
            //Integer employeeId = employee.getEmployeeId();
            
            String orderId = request.getParameter("orderToApprove");
            Orders order = filmaticBean.getOrder(orderId);
            
            // Get the Customer from the orderId, which holds customerId
            Customer customer = order.getCustomerId();
            Integer customerId = customer.getCustomerId();
            
            // Get the Accounttype from customer, which holds accountType
            Accounttype accountType = customer.getAccountType();
            
            // Get the Movie from the orderId, which holds movieId
            Movie movie = order.getMovieId();
            boolean available = filmaticBean.checkAvailability(movie);
            
            if (available) {
                if (accountType.getAccountType() == 1) {
                    if (filmaticBean.checkCustomerLimit(customerId) < 1) {
                        order.setCurrentlyOut(1);
                        order.setPending(0);
                        order.setEmployeeId(employee);
                        movie.setNumberCopies(movie.getNumberCopies() - 1);
                        movie.setTimesRented(movie.getTimesRented() + 1);
                        
                        filmaticBean.update(order);
                        filmaticBean.update(movie);
                        
                        // Re-populate rental list
                        Orders[] orders = filmaticBean.getPendingOrders();
                        request.getSession().setAttribute("pendingList", orders);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                        rd.forward(request, response);
                    }
                    else {
                        RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (accountType.getAccountType() == 2) {
                    if (filmaticBean.checkCustomerLimit(customerId) < 1) {
                        order.setCurrentlyOut(1);
                        order.setPending(0);
                        order.setEmployeeId(employee);
                        movie.setNumberCopies(movie.getNumberCopies() - 1);
                        movie.setTimesRented(movie.getTimesRented() + 1);
                        
                        filmaticBean.update(order);
                        filmaticBean.update(movie);
                        
                        // Re-populate rental list
                        Orders[] orders = filmaticBean.getPendingOrders();
                        request.getSession().setAttribute("pendingList", orders);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                        rd.forward(request, response);
                    }
                    else {
                        RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (accountType.getAccountType() == 3) {
                    if (filmaticBean.checkCustomerLimit(customerId) < 2) {
                        order.setCurrentlyOut(1);
                        order.setPending(0);
                        order.setEmployeeId(employee);
                        movie.setNumberCopies(movie.getNumberCopies() - 1);
                        movie.setTimesRented(movie.getTimesRented() + 1);
                        
                        filmaticBean.update(order);
                        filmaticBean.update(movie);
                        
                        // Re-populate rental list
                        Orders[] orders = filmaticBean.getPendingOrders();
                        request.getSession().setAttribute("pendingList", orders);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                        rd.forward(request, response);
                    }
                    else {
                        RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (accountType.getAccountType() == 4) {
                    order.setCurrentlyOut(1);
                    order.setPending(0);
                    order.setEmployeeId(employee);
                    movie.setNumberCopies(movie.getNumberCopies() - 1);
                    movie.setTimesRented(movie.getTimesRented() + 1);
                    
                    filmaticBean.update(order);
                    filmaticBean.update(movie);
                    
                    // Re-populate rental list
                    Orders[] orders = filmaticBean.getPendingOrders();
                    request.getSession().setAttribute("pendingList", orders);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                    rd.forward(request, response);
                }
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("custrep_orders.jsp");
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
