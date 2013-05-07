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
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import sessionBean.filmaticSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author Jonathan
 */
public class AddEmployeeServlet extends HttpServlet {

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
            Employee employee = new Employee();
            
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String currentTime = sdf.format(dt);
            
            Long accountId = filmaticBean.getNextAvailablePersonId();
            Integer id = accountId.intValue();
            
            String firstName = (String) request.getParameter("newEmployeeFirstName");
            String lastName = (String) request.getParameter("newEmployeeLastName");
            String email = (String) request.getParameter("newEmployeeEmail");
            String password = (String) request.getParameter("newEmployeePassword");
            String phone = (String) request.getParameter("newEmployeePhone");
            String address = (String) request.getParameter("newEmployeeAddress");
            String city = (String) request.getParameter("newEmployeeCity");
            String ssn = (String) request.getParameter("newEmployeeSSN");
            String state = (String) request.getParameter("newEmployeeState");
            States states = filmaticBean.getState(state);
            
            String zipCode = (String) request.getParameter("newEmployeeZipCode");
            String type = (String) request.getParameter("newEmployeeType");
            String hourlyWage = (String) request.getParameter("newEmployeeHourlyWage");
            
            person.setPersonId(id);
            
            if (type.equals("Rep"))
                person.setAccessLevel(1);
            else if (type.equals("Admin"))
                person.setAccessLevel(2);
            
            person.setAddress(address);
            person.setCity(city);
            person.setEmail(email);
            person.setPassword(password);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setTelephone(phone);
            person.setZipCode(zipCode);
            person.setStateAbrv(states);
           
            employee.setEmployeeId(id);
            if (type.equals("Rep"))
                employee.setEmployeeType("Customer Rep");
            else if (type.equals("Admin"))
                employee.setEmployeeType("Manager");
            
            employee.setSsn(ssn);
            
            Double wage = Double.parseDouble(hourlyWage);
            
            employee.setHourlyRate(BigDecimal.valueOf(wage));
            employee.setTransactionsManaged(0);
            employee.setStartDate(currentTime);
            
            filmaticBean.save(person);
            filmaticBean.save(employee);
            
            RequestDispatcher rd = request.getRequestDispatcher("AdminEmployeesServlet");
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
