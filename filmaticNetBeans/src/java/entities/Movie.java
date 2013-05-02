/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieId", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre = :genre"),
    @NamedQuery(name = "Movie.findByDistributionFee", query = "SELECT m FROM Movie m WHERE m.distributionFee = :distributionFee"),
    @NamedQuery(name = "Movie.findByNumberCopies", query = "SELECT m FROM Movie m WHERE m.numberCopies = :numberCopies"),
    @NamedQuery(name = "Movie.findByRating", query = "SELECT m FROM Movie m WHERE m.rating = :rating"),
    @NamedQuery(name = "Movie.findByTimesRented", query = "SELECT m FROM Movie m WHERE m.timesRented = :timesRented"),
    @NamedQuery(name = "Movie.findByTimesRated", query = "SELECT m FROM Movie m WHERE m.timesRated = :timesRated"),
    @NamedQuery(name = "Movie.findByImageLocation", query = "SELECT m FROM Movie m WHERE m.imageLocation = :imageLocation")})
public class Movie implements Serializable {
    @Size(max = 2000)
    @Column(name = "Summary")
    private String summary;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovieId")
    private Integer movieId;
    @Size(max = 140)
    @Column(name = "Title")
    private String title;
    @Size(max = 20)
    @Column(name = "Genre")
    private String genre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DistributionFee")
    private BigDecimal distributionFee;
    @Column(name = "NumberCopies")
    private Integer numberCopies;
    @Column(name = "Rating")
    private Integer rating;
    @Column(name = "TimesRented")
    private Integer timesRented;
    @Column(name = "TimesRated")
    private Integer timesRated;
    @Size(max = 45)
    @Column(name = "ImageLocation")
    private String imageLocation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "movie")
    private Tags tags;
    @OneToMany(mappedBy = "movieId")
    private Collection<Orders> ordersCollection;
    @OneToMany(mappedBy = "movieId")
    private Collection<Actsin> actsinCollection;

    public Movie() {
    }

    public Movie(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getDistributionFee() {
        return distributionFee;
    }

    public void setDistributionFee(BigDecimal distributionFee) {
        this.distributionFee = distributionFee;
    }

    public Integer getNumberCopies() {
        return numberCopies;
    }

    public void setNumberCopies(Integer numberCopies) {
        this.numberCopies = numberCopies;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTimesRented() {
        return timesRented;
    }

    public void setTimesRented(Integer timesRented) {
        this.timesRented = timesRented;
    }

    public Integer getTimesRated() {
        return timesRated;
    }

    public void setTimesRated(Integer timesRated) {
        this.timesRated = timesRated;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Actsin> getActsinCollection() {
        return actsinCollection;
    }

    public void setActsinCollection(Collection<Actsin> actsinCollection) {
        this.actsinCollection = actsinCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Movie[ movieId=" + movieId + " ]";
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
}
