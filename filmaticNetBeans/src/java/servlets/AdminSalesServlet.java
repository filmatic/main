/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Customer;
import entities.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DateString;
import sessionBean.filmaticSessionBean;

/**
 *
 * @author kris
 */
public class AdminSalesServlet extends HttpServlet {

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
            
            // CREATE A MAP OF ACCOUNT TYPES
            
            // GET MONTH
            Integer month = Integer.valueOf(request.getParameter("selectmonth"));
            if (month==null) month = 0;
            String monthStr = month.toString();
            if (month<10) {
                monthStr = "0"+month;
            }
            
            // GET YEAR
            Integer year = Integer.valueOf(request.getParameter("selectyear"));
            if (year==null) year=1000;
            
            // MAKE A COMPARE OBJECT
            DateString userSelectedDate = new DateString(year+"-"+monthStr+"-00");
            System.out.println(userSelectedDate.getDateString());
            
            // GET ALL CUSTOEMRS
            Customer[] allCustomers = filmaticBean.getCustomers();
            
            // CREATE A SELECTED CUSTOMER LIST
            ArrayList<Customer> selectedCustomersList = new ArrayList<Customer>();
            
            for (Customer c : allCustomers) {
                
                DateString customerDate = new DateString(c.getAccountCreationDate());
                
                // CUSTOMER DATE IS BIGGER THAN THE SELECTED 
                if (userSelectedDate.compare(customerDate)) {
                    selectedCustomersList.add(c);
                }
            }
            
            // MAKE A CUSTOMER ARRAY
            Customer[] selectedCustomers = selectedCustomersList.toArray(new Customer[selectedCustomersList.size()]);
            
            // CALCULATE TOTAL
            double total = 0;
            for (Customer c : selectedCustomers) {
                total+=10.00; // c.getAccountType();
            }
            
            // SET THE TOTAL
            request.getSession().setAttribute("salesTotal", total);
            
            // SET THE CUSTOMER ARRAY
            request.getSession().setAttribute("selectedCustomers", selectedCustomers);
            
            RequestDispatcher rd = request.getRequestDispatcher("admin_sales.jsp");
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
