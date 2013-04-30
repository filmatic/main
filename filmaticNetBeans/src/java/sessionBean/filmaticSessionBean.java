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
    
    public void removeFromCurrentUserQueue(Integer personId, Integer movieId) {
        String queryToRun = "DELETE FROM Moviequeue WHERE accountNumber=" + personId + " AND movieId=" + movieId;
        Query query = emf.createEntityManager().createNativeQuery(queryToRun);
        query.executeUpdate();
    }
    
}
