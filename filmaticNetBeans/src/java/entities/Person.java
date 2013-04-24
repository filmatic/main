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
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person.findByAddress", query = "SELECT p FROM Person p WHERE p.address = :address"),
    @NamedQuery(name = "Person.findByCity", query = "SELECT p FROM Person p WHERE p.city = :city"),
    @NamedQuery(name = "Person.findByZipCode", query = "SELECT p FROM Person p WHERE p.zipCode = :zipCode"),
    @NamedQuery(name = "Person.findByTelephone", query = "SELECT p FROM Person p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Person.findByAccessLevel", query = "SELECT p FROM Person p WHERE p.accessLevel = :accessLevel")})
public class Person implements Serializable {
    @Column(name = "AccessLevel")
    private Integer accessLevel;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonId")
    private Integer personId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Size(max = 50)
    @Column(name = "Password")
    private String password;
    @Size(max = 20)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 20)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 50)
    @Column(name = "Address")
    private String address;
    @Size(max = 30)
    @Column(name = "City")
    private String city;
    @Size(max = 5)
    @Column(name = "ZipCode")
    private String zipCode;
    @Size(max = 20)
    @Column(name = "Telephone")
    private String telephone;
    @JoinTable(name = "moviequeue", joinColumns = {
        @JoinColumn(name = "AccountNumber", referencedColumnName = "PersonId")}, inverseJoinColumns = {
        @JoinColumn(name = "MovieId", referencedColumnName = "MovieId")})
    @ManyToMany
    private Collection<Movie> movieCollection;
    @JoinColumn(name = "StateAbrv", referencedColumnName = "StateAbrv")
    @ManyToOne
    private States stateAbrv;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Employee employee;

    public Person() {
    }

    public Person(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    public States getStateAbrv() {
        return stateAbrv;
    }

    public void setStateAbrv(States stateAbrv) {
        this.stateAbrv = stateAbrv;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Person[ personId=" + personId + " ]";
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }
    
}
