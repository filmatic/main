/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Orders.findByReturnDate", query = "SELECT o FROM Orders o WHERE o.returnDate = :returnDate"),
    @NamedQuery(name = "Orders.findByPending", query = "SELECT o FROM Orders o WHERE o.pending = :pending")})
public class Orders implements Serializable {
    @Size(max = 10)
    @Column(name = "ReturnDate")
    private String returnDate;
    @Size(max =     10)
    @Column(name = "DateTime")
    private String dateTime;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderId")
    private Integer orderId;
    @Column(name = "CurrentlyOut")
    private Integer currentlyOut;
    @Column(name = "Pending")
    private Integer pending;
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

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
}
