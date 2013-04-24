/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "Employee.findByEmployeeType", query = "SELECT e FROM Employee e WHERE e.employeeType = :employeeType"),
    @NamedQuery(name = "Employee.findBySsn", query = "SELECT e FROM Employee e WHERE e.ssn = :ssn"),
    @NamedQuery(name = "Employee.findByStartDate", query = "SELECT e FROM Employee e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Employee.findByHourlyRate", query = "SELECT e FROM Employee e WHERE e.hourlyRate = :hourlyRate"),
    @NamedQuery(name = "Employee.findByTransactionsManaged", query = "SELECT e FROM Employee e WHERE e.transactionsManaged = :transactionsManaged")})
public class Employee implements Serializable {
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmployeeId")
    private Integer employeeId;
    @Size(max = 20)
    @Column(name = "EmployeeType")
    private String employeeType;
    @Size(max = 11)
    @Column(name = "SSN")
    private String ssn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HourlyRate")
    private BigDecimal hourlyRate;
    @Column(name = "TransactionsManaged")
    private Integer transactionsManaged;
    @OneToMany(mappedBy = "employeeId")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "EmployeeId", referencedColumnName = "PersonId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Integer getTransactionsManaged() {
        return transactionsManaged;
    }

    public void setTransactionsManaged(Integer transactionsManaged) {
        this.transactionsManaged = transactionsManaged;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employee[ employeeId=" + employeeId + " ]";
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
}
