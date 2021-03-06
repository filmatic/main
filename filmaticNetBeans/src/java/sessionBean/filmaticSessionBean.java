/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entities.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import javax.sql.DataSource;

/**
 *
 * @author Jonathan
 */
@Stateless
@LocalBean
public class filmaticSessionBean {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    /**
     * Saves the entity object passed in. Objects that already exist should be
     * updated with update. Trying to save a object that already exists will
     * throw an Exception.
     *
     * @param object
     */
    public void save(Object object) {
        emf.createEntityManager().persist(object);
    }
    
    /**
     * Updates the entity object passed in. Can also save new objects. But
     * changes will not be tracked? Look up API for more details for difference
     * between merge() and save().
     *
     * @param object
     */
    public void update(Object object) {
        emf.createEntityManager().merge(object);
    }
    
    /**
     * checkUser() will take in username and password and search for a match in the Person table.  
     * If the credentials match, a Person will be returned from the table.  Else, null.
     * 
     * @param username
     * @param password
     * @return Person if credentials match; null otherwise.
     */
    public Person checkUser(String username, String password) {
        
        Query query = emf.createEntityManager().createQuery("SELECT p.personId FROM Person p WHERE p.email = :username");
        List<Integer> searchResults = query.setParameter("username", username).getResultList();
        Integer[] results = (Integer[]) searchResults.toArray(new Integer[searchResults.size()]);
        
        if (results.length==0) return null;
        
        Integer result = results[0];
        //System.out.println(result);
        
        Person person = (Person) emf.createEntityManager().find(Person.class, result);
        if (person != null) {
            if (person.getPassword().equals(password)) {
                return person;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @param personId
     * @return 
     */
    public Person getPerson(Integer personId) {
        Person person = (Person) emf.createEntityManager().find(Person.class, personId);
        if (person != null) {
            return person;
        } else {
            return null;
        }
    }
    
    /**
     * Converts a Person to a Customer
     * @return Person[]
     */
    public Person[] getCustomersFromPerson() {
        String queryToRun = "SELECT p FROM Person p, Customer c WHERE p.personId = c.customerId";
        List<Person> searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        return searchResults.toArray(new Person[searchResults.size()]);
    }
    
    /**
     * 
     * @return 
     */
    public Customer[] getCustomers() {
        String queryToRun = "SELECT c FROM Customer c, Person p WHERE p.personId = c.customerId";
        List<Customer> searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        return searchResults.toArray(new Customer[searchResults.size()]);
    }
    
    /**
     * 
     * @param movieId
     * @return 
     */
    public Movie getMovie(Integer movieId) {
        Movie movie = (Movie) emf.createEntityManager().find(Movie.class, movieId);
        if (movie != null) {
            return movie;
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @return 
     */
    public Actor[] getAllActors() {
        List<Actor> searchResults = emf.createEntityManager().createQuery("SELECT a FROM Actor a ORDER BY a.actorName").getResultList();
        return searchResults.toArray(new Actor[searchResults.size()]);
    }
    
    
    /**
     * 
     * @return 
     */
    public Movie[] getAllMovies() {
        List<Movie> searchResults = emf.createEntityManager().createQuery("SELECT m FROM Movie m ORDER BY m.title").getResultList();   
        return searchResults.toArray(new Movie[searchResults.size()]);
    }
    
    public Movie[] getAllMovies(String sortType) {
        String queryToRun = null;
        List<Movie> searchResults = null;
        if (sortType.equals("title")) {
            queryToRun = "SELECT m FROM Movie m ORDER BY m.title";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        else if (sortType.equals("genre")) {
            queryToRun = "SELECT m FROM Movie m ORDER BY m.genre";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        else if (sortType.equals("movieId")) {
            queryToRun = "SELECT m FROM Movie m ORDER BY m.movieId ASC";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        else if (sortType.equals("numberOfCopies")) {
            queryToRun = "SELECT m FROM Movie m ORDER BY m.numberCopies DESC";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        else if (sortType.equals("timesRated")) {
            queryToRun = "SELECT m FROM Movie m ORDER BY m.timesRated DESC";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        return searchResults.toArray(new Movie[searchResults.size()]);
    }
    
        /**
     * 
     * @return 
     */
    public States[] getStateAcronyms() {
        List<States> searchResults = emf.createEntityManager().createQuery("SELECT s FROM States s").getResultList();
        return searchResults.toArray(new States[searchResults.size()]);
    }
    
    /**
     * 
     * @param person
     * @return 
     */
    public Movie[] getAllMoviesNotInQueue(Person person) {
        
        List<Movie> searchResults = emf.createEntityManager().createQuery("SELECT m FROM Movie m ORDER BY m.title").getResultList();
        Movie[] newSearchResults = new Movie[searchResults.size()];
        
        Integer personId = person.getPersonId();
        String personIdString = personId + "";
        int counter = 0;
        
        for (int i = 0; i < searchResults.size(); i++) {
            if ( (existsInQueue(personIdString, searchResults.get(i).getMovieId()) == false) && (existsInOrders(person.getCustomer(), searchResults.get(i)) == false) ) {
                newSearchResults[counter] = (searchResults.get(i));
                counter++;
            }
        }
        
        int newCounter = 0;
        for (int i = 0; i < newSearchResults.length; i++) {
            if (newSearchResults[i] != null) {
                newCounter++;
            } 
        }
        
        //System.out.println(newCounter);
        
        Movie[] finalResults = new Movie[newCounter];
        for (int i = 0; i < finalResults.length; i++) {
            finalResults[i] = newSearchResults[i];
        }
        
        
        
        return finalResults; 
    }
    
    /**
     * 
     * @param personId
     * @param movieId
     * @return 
     */
    public boolean existsInQueue(String personId, Integer movieId) {
        Query query = emf.createEntityManager().createQuery("SELECT m FROM Moviequeue m WHERE m.accountNumber = :personId");
        List<Moviequeue> searchResults = query.setParameter("personId", Integer.parseInt(personId)).getResultList();
        if (searchResults == null) {
            return false;
        } else {
            for (int i = 0; i < searchResults.size(); i++) {
                if (searchResults.get(i).getMovieId() == movieId) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public boolean existsInOrders(Customer customer, Movie movie) {
        Query query = emf.createEntityManager().createQuery("SELECT o FROM Orders o WHERE (o.pending = 1 OR o.currentlyOut = 1) AND o.customerId = :personId");
        List<Orders> searchResults = query.setParameter("personId", customer).getResultList();
        if (searchResults == null) {
            return false;
        } else {
            for (int i = 0; i < searchResults.size(); i++) {
                if (searchResults.get(i).getMovieId() == movie) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * 
     * @param personId
     * @return 
     */
    public Moviequeue[] getCurrentUserQueue(Integer personId) {
        Query query = emf.createEntityManager().createQuery("SELECT m FROM Moviequeue m WHERE m.accountNumber = :personId");
        List<Moviequeue> searchResults = query.setParameter("personId", personId).getResultList();
        if (searchResults == null) {
            return null;
        } else {
            return searchResults.toArray(new Moviequeue[searchResults.size()]);
        }
    }
    
    /**
     * 
     * @return 
     */
    public Integer getMaxMovieId() {
        String moviequeue = (String) emf.createEntityManager().createNativeQuery("SELECT CAST(MAX(CAST(moviequeueid AS SIGNED)) AS CHAR(20)) FROM Moviequeue").getSingleResult();
        if (moviequeue == null) {
            return 0;
        } else {
            int itemid = Integer.parseInt(moviequeue);
            itemid++;
            return itemid;
        }
    }
    
    public Long getNextOrdersId() {
        String queryToRun = "SELECT MAX(OrderId) + 1 FROM Orders";
        Long nextSlot = (Long) emf.createEntityManager().createNativeQuery(queryToRun).getSingleResult();
        if (nextSlot == null || nextSlot == 0) {
            return Long.getLong("0");
        } else {
            return nextSlot;
        }
    }
    
    /**
     * 
     * @return 
     */
    public Long getNextAvailablePersonId() {
        String queryToRun = "SELECT MAX(PersonId) + 1 FROM Person";
        Long nextSlot = (Long) emf.createEntityManager().createNativeQuery(queryToRun).getSingleResult();
        return nextSlot;
    }
    
    /**
     * 
     * @param personId
     * @param movieId 
     */
    public void removeFromCurrentUserQueue(Integer personId, Integer movieId) {
        String queryToRun = "DELETE FROM Moviequeue WHERE accountNumber=" + personId + " AND movieId=" + movieId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param personId
     * @return 
     */
    public Customer getCustomer(Integer personId) {
        Customer customer = (Customer) emf.createEntityManager().find(Customer.class, personId);
        if (customer != null) {
            return customer;
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @param personId
     * @return 
     */
    public Employee getEmployee(Integer personId) {
        Employee employee = (Employee) emf.createEntityManager().find(Employee.class, personId);
        if (employee != null) {
            return employee;
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @param customer 
     */
    public void increaseLoginCount(Customer customer) {
        String queryToRun = "SELECT c.timesLoggedIn FROM Customer c WHERE c.customerId=" + customer.getCustomerId();
        Integer loginCount = (Integer) emf.createEntityManager().createNativeQuery(queryToRun).getSingleResult();
        loginCount++;
        customer.setTimesLoggedIn(loginCount);
        emf.createEntityManager().merge(customer);
    }
    
    /**
     * 
     * @param state
     * @return 
     */
    public States getState(String state) {
        States states = (States) emf.createEntityManager().find(States.class, state);
        if (states != null) {
            return states;
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @return 
     
    public States[] getStates() {
        List<States> searchResults = emf.createEntityManager().createNativeQuery("SELECT s FROM States").getResultList();
        return searchResults.toArray(new States[searchResults.size()]);
    }*/
    
    /**
     * 
     * @param keyword
     * @param type
     * @return 
     */
    public Movie[] search(String keyword, String type) {
        TypedQuery<Movie> query;
        List<Movie> searchResults = null;
        if (!keyword.equals("null")) {
            if (type.equals("genre")) {
                query = emf.createEntityManager().createQuery("SELECT m FROM Movie m WHERE m.numberCopies > 0 AND m.genre LIKE :genre", Movie.class);
                searchResults = query.setParameter("genre","%" + keyword + "%").getResultList();
            }
            else if (type.equals("title")) {
                query = emf.createEntityManager().createQuery("SELECT m FROM Movie m WHERE m.numberCopies > 0 AND m.title LIKE :title", Movie.class);
                searchResults = query.setParameter("title","%" + keyword + "%").getResultList();
            }
            else if (type.equals("keyword")) {
                query = emf.createEntityManager().createQuery("SELECT m FROM Movie m WHERE m.numberCopies > 0 AND m.title LIKE :title", Movie.class);
                searchResults = query.setParameter("title","%" + keyword + "%").getResultList();
            }
        }
        else {
            query = emf.createEntityManager().createQuery("SELECT m FROM Movie m WHERE m.numberCopies > 0 ORDER BY m.title", Movie.class);
            searchResults = query.getResultList();
        }
        return searchResults.toArray(new Movie[searchResults.size()]);
    }
    
    public Orders[] getCurrentCustomerMovies(Person person) {
        String queryToRun = "SELECT o FROM Orders o WHERE o.currentlyOut = 1 AND o.customerId.customerId="+person.getPersonId();
        List<Orders> searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        return searchResults.toArray(new Orders[searchResults.size()]);
    }
    
    /**
     * 
     * @return 
     */
    public Customer[] getMostActiveCustomers() {
        List<Customer> searchResults = emf.createEntityManager().createQuery("SELECT c FROM Customer c ORDER BY c.timesLoggedIn DESC").getResultList();
        if (searchResults.size() <= 10) {
            return searchResults.toArray(new Customer[searchResults.size()]);
        } else {
            return searchResults.toArray(new Customer[10]);
        }
    }
    
    /**
     * 
     * @return 
     */
    public Movie[] getMostRentedMovies() {
        List<Customer> searchResults = emf.createEntityManager().createQuery("SELECT m FROM Movie m ORDER BY m.timesRented DESC").getResultList();
        if (searchResults.size() < 10) {
            return searchResults.toArray(new Movie[searchResults.size()]);
        } else {
            return searchResults.toArray(new Movie[10]);
        }
    }
    
    /**
     * 
     * @param customerId
     * @return 
     */
    public Person convertCustomerToPerson(String customerId) {
        String queryToRun = "SELECT p FROM Person p WHERE p.personId='" + customerId + "'";
        Person person = (Person) emf.createEntityManager().createQuery(queryToRun).getSingleResult();
        return person;
    }
    
    /**
     * 
     * @param employeeId
     * @return 
     */
    public Person convertEmployeeToPerson(String employeeId) {
        String queryToRun = "SELECT p FROM Person p WHERE p.personId='" + employeeId + "'";
        Person person = (Person) emf.createEntityManager().createQuery(queryToRun).getSingleResult();
        return person;
    }
    
    /**
     * 
     * @return 
     */
    public Object[] getOrdersObject() {
        String queryToRun = "SELECT m.movieId, m.title, m.genre, e.employeeId, c.customerId, o.dateTime FROM Movie m, Employee e, Customer c, Orders o WHERE o.movieId = m.movieId AND c.customerId = o.customerId AND e.employeeId = o.employeeId";
        List<Object> searchResults = (List<Object>) emf.createEntityManager().createNativeQuery(queryToRun).getResultList();
        return searchResults.toArray(new Object[searchResults.size()]);
    }
    
    /**
     * 
     * @param orderId
     * @return 
     */
    public Orders getOrder(String orderId) {
        String queryToRun = "SELECT o FROM Orders o WHERE o.orderId="+orderId;
        Orders order = (Orders) emf.createEntityManager().createQuery(queryToRun).getSingleResult();
        return order;
    }
    
    /**
     * 
     * @param movie
     * @return 
     */
    public boolean checkAvailability(Movie movie) {
        if (movie.getNumberCopies() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param customerId
     * @return 
     */
    public Integer checkCustomerLimit(Integer customerId) {
        String queryToRun = "SELECT * FROM Orders WHERE pending=0 AND currentlyOut=1 AND customerId="+customerId;
        List<Orders> searchResults = emf.createEntityManager().createNativeQuery(queryToRun).getResultList();
        return (searchResults.size());
    }
    
    /**
     * 
     * @return 
     */
    public Orders[] getPendingOrders() {
        String queryToRun = "SELECT o FROM Orders o WHERE o.pending=1";
        List<Orders> searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        return searchResults.toArray(new Orders[searchResults.size()]);
    }
    
    /**
     * 
     * @return 
     */
    public Orders[] getOrders() {
        String queryToRun = "SELECT o FROM Orders o";
        List<Orders> searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        return searchResults.toArray(new Orders[searchResults.size()]);
    }
    
    /**
     * 
     * @param customerId
     * @return 
     */
    public Orders[] getHistory(Integer customerId) {
        String queryToRun = "SELECT o FROM Orders o WHERE o.pending='0' AND o.customerId.customerId='" + customerId+"'";
        List<Orders> searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        return searchResults.toArray(new Orders[searchResults.size()]);
    }
    
    /**
     * 
     * @param sortType
     * @return 
     */
    public Orders[] getOrders(String sortType) {
        String queryToRun = null;
        List<Orders> searchResults = null;
        if (sortType.equals("movieId")) {
            queryToRun = "SELECT o FROM Orders o ORDER BY o.movieId.movieId ASC";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        else if (sortType.equals("customerId")) {
            queryToRun = "SELECT o FROM Orders o ORDER BY o.customerId.customerId";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        else if (sortType.equals("employeeId")) {
            queryToRun = "SELECT o FROM Orders o ORDER BY o.employeeId.employeeId";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        else if (sortType.equals("date")) {
            queryToRun = "SELECT o FROM Orders o ORDER BY o.dateTime";
            searchResults = emf.createEntityManager().createQuery(queryToRun).getResultList();
        }
        return searchResults.toArray(new Orders[searchResults.size()]);
    }
    
    /**
     * 
     * @return 
     */
    public Employee[] getEmployees() {
        List<Employee> searchResults = emf.createEntityManager().createQuery("SELECT e FROM Employee e").getResultList();
        return searchResults.toArray(new Employee[searchResults.size()]);
    }
    
    /**
     * 
     * @param movieId 
     */
    public void removeMovieFromActsIn(String movieId) {
        String queryToRun = "DELETE FROM Actsin WHERE movieId="+movieId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param movieId 
     */
    public void removeMovieFromOrders(String movieId) {
        String queryToRun = "DELETE FROM Orders WHERE movieId="+movieId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param movieId 
     */
    public void removeMovieFromMovieQueue(String movieId) {
        String queryToRun = "DELETE FROM Moviequeue WHERE movieId="+movieId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param movieId 
     */
    public void removeMovieFromMovie(String movieId) {
        String queryToRun = "DELETE FROM Movie WHERE movieId="+movieId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param employeeId 
     */
    public void removeEmployeeFromOrders(String employeeId) {
        String queryToRun = "DELETE FROM Orders WHERE employeeId="+employeeId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param employeeId 
     */
    public void removeEmployeeFromEmployee(String employeeId) {
        String queryToRun = "DELETE FROM Employee WHERE employeeId="+employeeId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param employeeId 
     */
    public void removeEmployeeFromPerson(String employeeId) {
        String queryToRun = "DELETE FROM Person WHERE personId="+employeeId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param actorId 
     */
    public void removeActorFromActsin(String actorId) {
        String queryToRun = "DELETE FROM Actsin WHERE actorId="+actorId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    /**
     * 
     * @param actorId 
     */
    public void removeActorFromActor(String actorId) {
        String queryToRun = "DELETE FROM Actor WHERE actorId="+actorId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
    
    public Movie[] getCustomerRecommendation(String customerId) {
        //customerId = ""
        
        String queryToRun = ""
                + "SELECT MovieId "
                + "FROM Movie M "
                + "NATURAL JOIN "
                + "( "
                //-- SELECT THE MOST COMMON GENRE WATCHED
                + "SELECT Genre FROM "
                + "( " 
                + "SELECT M.MovieId, M.Genre, COUNT(*) AS \"count\" "
                + "FROM Movie M "
                + "WHERE M.MovieId IN "
                + "( "
                // -- SELECT ALL THE MOVIES THE CUSTOMER HAS WATCHED
                + "SELECT O.MovieId "
                + "FROM Orders O "
                + "WHERE O.CustomerId = " + customerId 
                + " )"
                + "GROUP BY M.Genre "
                + "ORDER BY \"count\" DESC "
                + ") AS GenreCount "
                + "LIMIT 1 "
                + ") AS TopGenre ";
        
        //Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        //query.executeUpdate();

        // GET MOVIE ID's "SELECT MovieId"
        //List<Integer> searchResults = emf.createEntityManager().createNativeQuery(queryToRun).getResultList();
        // 
        
        List<Integer> searchResults = emf.createEntityManager().createNativeQuery(queryToRun).getResultList();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        
        /*em.createNamedQuery("findAllCustomersWithName")
            .setParameter("custName", "Smith")
            .getResultList();
        */
        
        for (Integer i : searchResults) {
            String query = "SELECT m FROM Movie m WHERE m.movieId = " + i.toString();
                    
            Movie m = (Movie)emf.createEntityManager().createQuery(query).getSingleResult();
            
            movies.add(m);
        }
        
        return movies.toArray(new Movie[movies.size()]);//(String[])searchResults.toArray();
    }
    
    
}
