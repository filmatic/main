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
    public Person getPerson(String personId) {
        Person person = (Person) emf.createEntityManager().find(Person.class, personId);
        if (person != null) {
            return person;
        } else {
            return null;
        }
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
    public Movie[] getAllMovies() {
        List<Movie> searchResults = emf.createEntityManager().createQuery("SELECT m FROM Movie m ORDER BY m.title").getResultList();   
        return searchResults.toArray(new Movie[searchResults.size()]);
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
            if (!existsInQueue(personIdString, searchResults.get(i).getMovieId())) {
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
        
        System.out.println(newCounter);
        
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
     * @return 
     */
    public States[] getStateAcronyms() {
        String queryToRun = "SELECT s FROM States s";
        List<States> searchResults = emf.createEntityManager().createNativeQuery(queryToRun).getResultList();
        return searchResults.toArray(new States[searchResults.size()]);
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
     * @param keyword
     * @param type
     * @return 
     */
    public Movie[] search(String keyword, String type) {
        TypedQuery<Movie> query;
        List<Movie> searchResults = null;
        if (!keyword.equals("null")) {
            if (type.equals("genre")) {
                query = emf.createEntityManager().createQuery("SELECT m FROM Movie m WHERE m.genre LIKE :genre", Movie.class);
                searchResults = query.setParameter("genre","%" + keyword + "%").getResultList();
            }
            else if (type.equals("title")) {
                query = emf.createEntityManager().createQuery("SELECT m FROM Movie m WHERE m.title LIKE :title", Movie.class);
                searchResults = query.setParameter("title","%" + keyword + "%").getResultList();
            }
            else if (type.equals("keyword")) {
                query = emf.createEntityManager().createQuery("SELECT m FROM Movie m WHERE m.title LIKE :title", Movie.class);
                searchResults = query.setParameter("title","%" + keyword + "%").getResultList();
            }
        }
        else {
            query = emf.createEntityManager().createQuery("SELECT m FROM Movie m ORDER BY m.title", Movie.class);
            searchResults = query.getResultList();
        }
        return searchResults.toArray(new Movie[searchResults.size()]);
    }
    
}
