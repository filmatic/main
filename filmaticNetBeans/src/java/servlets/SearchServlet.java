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
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import sessionBean.filmaticSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author Jonathan
 */
public class SearchServlet extends HttpServlet {

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
            
            String searchType = (String) request.getParameter("searchType");
            String keyword = (String) request.getParameter("searchKeyword");
            
            if (keyword == null) {
                keyword = "null";
            }
            
            //System.out.println("Touched");
            // GET RESULTS
            Movie[] results = filmaticBean.search(keyword, searchType);
            
            HashMap<Integer,String> actorsMap = new HashMap<Integer,String>();
            
            // GET ACTORS LOL
            Actor[] allActors = filmaticBean.getAllActors();
            //Actsin[] actorActsIn =  allActors[0].getActsinCollection().toArray(new Actsin[allActors[0].getActsinCollection().size()]);
            
            //if (actorActsIn.length <=0) System.out.println("EMPTYYYY AS SHIT");
            
            //for (Actsin a : actorActsIn) 
            //    System.out.println((a).getMovieId().getMovieId());
            //HashMap<
            
            for (Movie m : results) {
                String actorList = "";
                
                // GO THROUGH ALL TEH ACTORS
                for (int i=0;i<allActors.length;i++) {

                    Actor actor = allActors[i];

                    // GET ALL THE ACTS IN STUF
                    Actsin[] actorActsIn =  actor.getActsinCollection().toArray(new Actsin[actor.getActsinCollection().size()]);

                    for (Actsin a : actorActsIn) {
                        if (m.getMovieId()==a.getMovieId().getMovieId()) {
                            actorList = actorList + a.getActorId().getActorName() + "; ";
                        }
                        
                    }
                }
                
                actorsMap.put(m.getMovieId(), actorList);
            }
            
            
            request.getSession().setAttribute("actorsMap", actorsMap);
            /*
            //System.out.println("Touched again");
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i].getTitle());
            }*/
            
            request.getSession().setAttribute("searchResults", results);
            RequestDispatcher rd = request.getRequestDispatcher("customer_movies.jsp");
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
