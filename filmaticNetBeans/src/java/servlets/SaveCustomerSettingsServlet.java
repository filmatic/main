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
            Customer currentCustomer = (Customer) request.getSession().getAttribute("customer");
            //Customer currentCustomer = filmaticBean.getCustomer(currentUser.getPersonId());
            
            String newFirstName = (String) request.getParameter("customerName");
            String newLastName = null;
            
            int temp =  0;
            for (int i = 0; i < newFirstName.length(); i++) {
                if (newFirstName.charAt(i) == ' ') {
                    temp = i;
                    break;
                }
            }
            
            newLastName = newFirstName.substring(temp + 1, newFirstName.length());
            newFirstName = newFirstName.substring(0, temp);
            
            String newEmail = (String) request.getParameter("customerEmail");
            String newCardNumber = (String) request.getParameter("customerCardNumber");
            
            currentUser.setFirstName(newFirstName);
            currentUser.setLastName(newLastName);
            currentUser.setEmail(newEmail);
            currentCustomer.setCreditCardNumber(newCardNumber);
            
            System.out.println(currentCustomer.getCreditCardNumber());
            
            //request.setAttribute("person", currentUser);
            //request.setAttribute("customer", currentCustomer);
            
            filmaticBean.update(currentCustomer);
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
