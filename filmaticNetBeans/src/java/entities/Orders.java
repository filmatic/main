/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Orders.findByDateTime", query = "SELECT o FROM Orders o WHERE o.dateTime = :dateTime"),
    @NamedQuery(name = "Orders.findByCurrentlyOut", query = "SELECT o FROM Orders o WHERE o.currentlyOut = :currentlyOut"),
    @NamedQuery(name = "Orders.findByReturnDate", query = "SELECT o FROM Orders o WHERE o.returnDate = :returnDate")})
public class Orders implements Serializable {
    @Column(name = "DateTime")
    @Temporal(TemporalType.DATE)
    private Date dateTime;
    @Column(name = "ReturnDate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderId")
    private Integer orderId;
    @Column(name = "CurrentlyOut")
    private Integer currentlyOut;
    @JoinColumn(name = "MovieId", referencedColumnName = "MovieId")
    @ManyToOne
    private Movie movieId;
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne
    private Customer customerId;

    public Orders() {
    }

    public Orders(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCurrentlyOut() {
        return currentlyOut;
    }

    public void setCurrentlyOut(Integer currentlyOut) {
        this.currentlyOut = currentlyOut;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Orders[ orderId=" + orderId + " ]";
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
}
