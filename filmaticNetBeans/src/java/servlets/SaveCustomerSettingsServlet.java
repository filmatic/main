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
public class SaveCustomerSettingsServlet extends HttpServlet {

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
            
            Person currentUser = (Person) request.getSession().getAttribute("person");
            //Customer currentCustomer = (Customer) request.getSession().getAttribute("customer");
            //Customer currentCustomer = filmaticBean.getCustomer(currentUser.getPersonId());
            
            String newFirstName = (String) request.getParameter("customerFirstName");
            String newLastName = (String) request.getParameter("customerLastName");
            String newEmail = (String) request.getParameter("customerEmail");
            String newPassword = (String) request.getParameter("customerPassword");
            String newAddress = (String) request.getParameter("customerAddress");
            String newCity = (String) request.getParameter("customerCity");
            
            String stateTemp = (String) request.getParameter("customerState");
            States newState = filmaticBean.getState(stateTemp);
            
            String newZipcode = (String) request.getParameter("customerZipCode");
            String newTelephone = (String) request.getParameter("customerPhone");
            
            currentUser.setFirstName(newFirstName);
            currentUser.setLastName(newLastName);
            currentUser.setEmail(newEmail);
            currentUser.setPassword(newPassword);
            currentUser.setAddress(newAddress);
            currentUser.setStateAbrv(newState);
            currentUser.setCity(newCity);
            currentUser.setZipCode(newZipcode);
            currentUser.setTelephone(newTelephone);

            filmaticBean.update(currentUser);
            
            RequestDispatcher rd = request.getRequestDispatcher("customer_settings.jsp");
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
