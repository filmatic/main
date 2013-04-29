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
@Table(name = "moviequeue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviequeue.findAll", query = "SELECT m FROM Moviequeue m"),
    @NamedQuery(name = "Moviequeue.findByMovieQueueId", query = "SELECT m FROM Moviequeue m WHERE m.movieQueueId = :movieQueueId"),
    @NamedQuery(name = "Moviequeue.findByAccountNumber", query = "SELECT m FROM Moviequeue m WHERE m.accountNumber = :accountNumber"),
    @NamedQuery(name = "Moviequeue.findByMovieId", query = "SELECT m FROM Moviequeue m WHERE m.movieId = :movieId")})
public class Moviequeue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovieQueueId")
    private Integer movieQueueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccountNumber")
    private int accountNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovieId")
    private int movieId;

    public Moviequeue() {
    }

    public Moviequeue(Integer movieQueueId) {
        this.movieQueueId = movieQueueId;
    }

    public Moviequeue(Integer movieQueueId, int accountNumber, int movieId) {
        this.movieQueueId = movieQueueId;
        this.accountNumber = accountNumber;
        this.movieId = movieId;
    }

    public Integer getMovieQueueId() {
        return movieQueueId;
    }

    public void setMovieQueueId(Integer movieQueueId) {
        this.movieQueueId = movieQueueId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieQueueId != null ? movieQueueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviequeue)) {
            return false;
        }
        Moviequeue other = (Moviequeue) object;
        if ((this.movieQueueId == null && other.movieQueueId != null) || (this.movieQueueId != null && !this.movieQueueId.equals(other.movieQueueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Moviequeue[ movieQueueId=" + movieQueueId + " ]";
    }
    
}
