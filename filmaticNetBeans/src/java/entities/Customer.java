/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByAccountCreationDate", query = "SELECT c FROM Customer c WHERE c.accountCreationDate = :accountCreationDate"),
    @NamedQuery(name = "Customer.findByCreditCardNumber", query = "SELECT c FROM Customer c WHERE c.creditCardNumber = :creditCardNumber"),
    @NamedQuery(name = "Customer.findByRating", query = "SELECT c FROM Customer c WHERE c.rating = :rating"),
    @NamedQuery(name = "Customer.findByTimesLoggedIn", query = "SELECT c FROM Customer c WHERE c.timesLoggedIn = :timesLoggedIn")})
public class Customer implements Serializable {
    @Column(name =     "AccountCreationDate")
    @Temporal(TemporalType.DATE)
    private Date accountCreationDate;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerId")
    private Integer customerId;
    @Size(max = 16)
    @Column(name = "CreditCardNumber")
    private String creditCardNumber;
    @Column(name = "Rating")
    private Integer rating;
    @Column(name = "TimesLoggedIn")
    private Integer timesLoggedIn;
    @OneToMany(mappedBy = "customerId")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "AccountType", referencedColumnName = "AccountType")
    @ManyToOne
    private Accounttype accountType;
    @JoinColumn(name = "CustomerId", referencedColumnName = "PersonId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTimesLoggedIn() {
        return timesLoggedIn;
    }

    public void setTimesLoggedIn(Integer timesLoggedIn) {
        this.timesLoggedIn = timesLoggedIn;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Accounttype getAccountType() {
        return accountType;
    }

    public void setAccountType(Accounttype accountType) {
        this.accountType = accountType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customer[ customerId=" + customerId + " ]";
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }
    
}
