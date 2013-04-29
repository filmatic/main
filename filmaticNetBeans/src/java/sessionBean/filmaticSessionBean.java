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
     * @param movieId
     * @return 
     */
    public Movie getMovie(String movieId) {
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
    
}
