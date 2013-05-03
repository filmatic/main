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
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import sessionBean.filmaticSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author Jonathan
 */
public class RegisterNewUserServlet extends HttpServlet {

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
            System.out.println(currentTime);
            
            Long accountId = filmaticBean.getNextAvailablePersonId();
            Integer id = accountId.intValue();
            
            person.setPersonId(id);
            customer.setCustomerId(id);
            
            String email = request.getParameter("customerEmail");
            person.setEmail(email);
            
            String password = request.getParameter("customerPassword");
            person.setPassword(password);
            
            String firstName = request.getParameter("customerFirstName");
            person.setFirstName(firstName);
            
            String lastName = request.getParameter("customerLastName");
            person.setLastName(lastName);
            
            String phone = request.getParameter("customerPhone");
            person.setTelephone(phone);
            
            String address = request.getParameter("customerAddress");
            person.setAddress(address);
            
            String state = request.getParameter("customerState");
            States states = filmaticBean.getState(state);
            person.setStateAbrv(states);
            
            String zipCode = request.getParameter("customerZipCode");
            person.setZipCode(zipCode);
            
            person.setAccessLevel(0);
            
            String creditCardNumber = request.getParameter("customerCreditCardNumber");
            customer.setCreditCardNumber(creditCardNumber);
            
            customer.setRating(0);
            customer.setTimesLoggedIn(0);
             
            String plan = request.getParameter("plan");
            if (plan.equals("1")) {
                customer.setAccountType(new Accounttype(1));
            } else if (plan.equals("2")) {
                customer.setAccountType(new Accounttype(2));
            } else if (plan.equals("3")) {
                customer.setAccountType(new Accounttype(3));
            } else if (plan.equals("4")) {
                customer.setAccountType(new Accounttype(4));
            }
            
            customer.setAccountCreationDate(currentTime);
            
            filmaticBean.save(person);
            filmaticBean.save(customer);
                   
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
