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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "accounttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounttype.findAll", query = "SELECT a FROM Accounttype a"),
    @NamedQuery(name = "Accounttype.findByAccountType", query = "SELECT a FROM Accounttype a WHERE a.accountType = :accountType"),
    @NamedQuery(name = "Accounttype.findByMonthlyFee", query = "SELECT a FROM Accounttype a WHERE a.monthlyFee = :monthlyFee"),
    @NamedQuery(name = "Accounttype.findByMoviesPerMonth", query = "SELECT a FROM Accounttype a WHERE a.moviesPerMonth = :moviesPerMonth"),
    @NamedQuery(name = "Accounttype.findByMoviesAtATime", query = "SELECT a FROM Accounttype a WHERE a.moviesAtATime = :moviesAtATime")})
public class Accounttype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccountType")
    private Integer accountType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MonthlyFee")
    private BigDecimal monthlyFee;
    @Column(name = "MoviesPerMonth")
    private Integer moviesPerMonth;
    @Column(name = "MoviesAtATime")
    private Integer moviesAtATime;
    @OneToMany(mappedBy = "accountType")
    private Collection<Customer> customerCollection;

    public Accounttype() {
    }

    public Accounttype(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public Integer getMoviesPerMonth() {
        return moviesPerMonth;
    }

    public void setMoviesPerMonth(Integer moviesPerMonth) {
        this.moviesPerMonth = moviesPerMonth;
    }

    public Integer getMoviesAtATime() {
        return moviesAtATime;
    }

    public void setMoviesAtATime(Integer moviesAtATime) {
        this.moviesAtATime = moviesAtATime;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountType != null ? accountType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounttype)) {
            return false;
        }
        Accounttype other = (Accounttype) object;
        if ((this.accountType == null && other.accountType != null) || (this.accountType != null && !this.accountType.equals(other.accountType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Accounttype[ accountType=" + accountType + " ]";
    }
    
}
