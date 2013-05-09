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
public class AddNewCustomerServlet extends HttpServlet {

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
            
            Person person = new Person();
            Customer customer = new Customer();
            
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String currentTime = sdf.format(dt);
            
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
            
            Long accountId = filmaticBean.getNextAvailablePersonId();
            Integer id = accountId.intValue();
            
            person.setPersonId(id);
            customer.setCustomerId(id);
            
            person.setFirstName(newFirstName);
            person.setLastName(newLastName);
            person.setEmail(newEmail);
            person.setPassword(newPassword);
            person.setAddress(newAddress);
            person.setCity(newCity);
            person.setStateAbrv(newState);
            person.setZipCode(newZipcode);
            person.setTelephone(newTelephone);
            person.setAccessLevel(0);
            
            customer.setTimesLoggedIn(0);
            customer.setRating(0);
            customer.setAccountCreationDate(currentTime);
            String customerPlan = (String) request.getParameter("customerPlan");
            if (customerPlan.equals("1")) {
                customer.setAccountType(new Accounttype(1));
            } else if (customerPlan.equals("2")) {
                customer.setAccountType(new Accounttype(2));
            } else if (customerPlan.equals("3")) {
                customer.setAccountType(new Accounttype(3));
            } else if (customerPlan.equals("4")) {
                customer.setAccountType(new Accounttype(4));
            }
            
            String customerCardNumber = (String) request.getParameter("customerCardNumber");
            customer.setCreditCardNumber(customerCardNumber);
            
            filmaticBean.save(person);
            filmaticBean.save(customer);
            
            Person[] customers = filmaticBean.getCustomersFromPerson();
            request.getSession().setAttribute("customerList", customers);
            
            RequestDispatcher rd = request.getRequestDispatcher("custrep_customers.jsp");
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
