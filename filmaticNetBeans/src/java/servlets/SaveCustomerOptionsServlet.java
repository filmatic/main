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
public class SaveCustomerOptionsServlet extends HttpServlet {
    
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
            
            Customer currentCustomer = (Customer) request.getSession().getAttribute("customer");
            //Customer customer = (Customer) filmaticBean.getCustomer(currentCustomer.getCustomerId());
            
            String customerPlan = (String) request.getParameter("plan");
            
            if (customerPlan.equals("1")) {
                currentCustomer.setAccountType(new Accounttype(1));
            } else if (customerPlan.equals("2")) {
                currentCustomer.setAccountType(new Accounttype(2));
            } else if (customerPlan.equals("3")) {
                currentCustomer.setAccountType(new Accounttype(2));
            } else if (customerPlan.equals("4")) {
                currentCustomer.setAccountType(new Accounttype(2));
            }
            
            String customerCardNumber = (String) request.getParameter("customerCardNumber");
            currentCustomer.setCreditCardNumber(customerCardNumber);
            
            filmaticBean.update(currentCustomer);
            
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