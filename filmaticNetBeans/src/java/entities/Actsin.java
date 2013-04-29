/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "actsin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actsin.findAll", query = "SELECT a FROM Actsin a"),
    @NamedQuery(name = "Actsin.findByActsInId", query = "SELECT a FROM Actsin a WHERE a.actsInId = :actsInId")})
public class Actsin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ActsInId")
    private Integer actsInId;
    @JoinColumn(name = "MovieId", referencedColumnName = "MovieId")
    @ManyToOne
    private Movie movieId;
    @JoinColumn(name = "ActorId", referencedColumnName = "ActorId")
    @ManyToOne
    private Actor actorId;

    public Actsin() {
    }

    public Actsin(Integer actsInId) {
        this.actsInId = actsInId;
    }

    public Integer getActsInId() {
        return actsInId;
    }

    public void setActsInId(Integer actsInId) {
        this.actsInId = actsInId;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public Actor getActorId() {
        return actorId;
    }

    public void setActorId(Actor actorId) {
        this.actorId = actorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actsInId != null ? actsInId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actsin)) {
            return false;
        }
        Actsin other = (Actsin) object;
        if ((this.actsInId == null && other.actsInId != null) || (this.actsInId != null && !this.actsInId.equals(other.actsInId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Actsin[ actsInId=" + actsInId + " ]";
    }
    
}
