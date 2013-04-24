/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Jonathan
 */
@Stateless
@LocalBean
public class filmaticSessionBean {

    @PersistenceUnit
    EntityManagerFactory emf;
    
}
