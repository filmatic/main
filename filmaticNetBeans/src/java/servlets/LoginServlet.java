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
public class LoginServlet extends HttpServlet {

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
            // GET USERNAME AND PASSWORD
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            Customer customer = null;
            Employee employee = null;
            
            // CHECK IF THE USER EXISTS
            Person person = filmaticBean.checkUser(username, password);
            
            Integer zero = 0;
            
            if (person != null) {
                
                // ADD PERSON OBJECT TO SESSION
                request.getSession().setAttribute("person", person);
                
                // PERSON IS A CUSTOMER
                if (person.getAccessLevel() == 0) {
                    customer = filmaticBean.getCustomer(person.getPersonId());
                    filmaticBean.increaseLoginCount(customer);
                    request.getSession().setAttribute("customer", customer);
                    RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
                    rd.forward(request, response);
                }
                
                // PERSON IS AN ADMIN
                else if (person.getAccessLevel() == 2) {
                    employee = filmaticBean.getEmployee(person.getPersonId());
                    request.getSession().setAttribute("employee", employee);
                    RequestDispatcher rd = request.getRequestDispatcher("AdminHomeServlet");
                    rd.forward(request, response);
                }           
                // PERSON IS A CUSTOMER REPRESENTATIVE
                else if (person.getAccessLevel() == 1) {
                    employee = filmaticBean.getEmployee(person.getPersonId());
                    request.getSession().setAttribute("employee", employee);
                    RequestDispatcher rd = request.getRequestDispatcher("CustRepHomeServlet");
                    rd.forward(request, response);
                }
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            }
            // INVALID PASSWORD/USERNAME
            else {
                // SET INVALID PW FLAG
                boolean invalidpw = true;
                request.setAttribute("invalidpw", invalidpw);
                
                // SET THE USER NAME
                request.setAttribute("username",username);

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
