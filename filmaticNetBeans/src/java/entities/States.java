/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "states")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "States.findAll", query = "SELECT s FROM States s"),
    @NamedQuery(name = "States.findByState", query = "SELECT s FROM States s WHERE s.state = :state"),
    @NamedQuery(name = "States.findByStateAbrv", query = "SELECT s FROM States s WHERE s.stateAbrv = :stateAbrv")})
public class States implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 15)
    @Column(name = "State")
    private String state;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "StateAbrv")
    private String stateAbrv;
    @OneToMany(mappedBy = "stateAbrv")
    private Collection<Person> personCollection;

    public States() {
    }

    public States(String stateAbrv) {
        this.stateAbrv = stateAbrv;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbrv() {
        return stateAbrv;
    }

    public void setStateAbrv(String stateAbrv) {
        this.stateAbrv = stateAbrv;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateAbrv != null ? stateAbrv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof States)) {
            return false;
        }
        States other = (States) object;
        if ((this.stateAbrv == null && other.stateAbrv != null) || (this.stateAbrv != null && !this.stateAbrv.equals(other.stateAbrv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.States[ stateAbrv=" + stateAbrv + " ]";
    }
    
}
