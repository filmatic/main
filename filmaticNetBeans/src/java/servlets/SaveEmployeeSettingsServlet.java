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
public class SaveEmployeeSettingsServlet extends HttpServlet {

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
            
            String personId = (String) request.getParameter("employeePersonId");
            Person person = filmaticBean.getPerson(Integer.parseInt(personId));
            Employee employee = filmaticBean.getEmployee(person.getPersonId());
            
            String firstName = (String) request.getParameter("employeeFirstName");
            String lastName = (String) request.getParameter("employeeLastName");
            String email = (String) request.getParameter("employeeEmail");
            String password = (String) request.getParameter("employeePassword");
            String phone = (String) request.getParameter("employeePhone");
            String address = (String) request.getParameter("employeeAddress");
            String city = (String) request.getParameter("employeeCity");
            //String ssn = (String) request.getParameter("employeeSSN");
            String state = (String) request.getParameter("employeeState");
            States states = filmaticBean.getState(state);
            
            String zipCode = (String) request.getParameter("employeeZipCode");
            String type = (String) request.getParameter("employeeType");
            String hourlyWage = (String) request.getParameter("employeeHourlyWage");
            
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
            
            if (type.equals("Rep"))
                employee.setEmployeeType("Customer Rep");
            else if (type.equals("Admin"))
                employee.setEmployeeType("Manager");
            
            Double wage = Double.parseDouble(hourlyWage);
            
            employee.setHourlyRate(BigDecimal.valueOf(wage));
            
            filmaticBean.update(employee);
            filmaticBean.update(person);
            
            
            Employee[] employee2 = filmaticBean.getEmployees();
            Person[] employees = new Person[employee2.length];
            String temp = null;
            
            for (int i = 0; i < employee2.length; i++) {
                temp = "";
                temp += employee2[i].getEmployeeId();
                employees[i] = filmaticBean.convertEmployeeToPerson(temp);
            }
 
            request.getSession().setAttribute("employeeList", employees);
            
            RequestDispatcher rd = request.getRequestDispatcher("admin_employees.jsp");
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
