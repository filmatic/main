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
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findByActorId", query = "SELECT a FROM Actor a WHERE a.actorId = :actorId"),
    @NamedQuery(name = "Actor.findByActorName", query = "SELECT a FROM Actor a WHERE a.actorName = :actorName"),
    @NamedQuery(name = "Actor.findByGender", query = "SELECT a FROM Actor a WHERE a.gender = :gender"),
    @NamedQuery(name = "Actor.findByAge", query = "SELECT a FROM Actor a WHERE a.age = :age"),
    @NamedQuery(name = "Actor.findByRating", query = "SELECT a FROM Actor a WHERE a.rating = :rating")})
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ActorId")
    private Integer actorId;
    @Size(max = 50)
    @Column(name = "ActorName")
    private String actorName;
    @Size(max = 7)
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Rating")
    private Integer rating;
    @JoinTable(name = "actsin", joinColumns = {
        @JoinColumn(name = "ActorId", referencedColumnName = "ActorId")}, inverseJoinColumns = {
        @JoinColumn(name = "MovieId", referencedColumnName = "MovieId")})
    @ManyToMany
    private Collection<Movie> movieCollection;

    public Actor() {
    }

    public Actor(Integer actorId) {
        this.actorId = actorId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @XmlTransient
    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actorId != null ? actorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.actorId == null && other.actorId != null) || (this.actorId != null && !this.actorId.equals(other.actorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Actor[ actorId=" + actorId + " ]";
    }
    
}
