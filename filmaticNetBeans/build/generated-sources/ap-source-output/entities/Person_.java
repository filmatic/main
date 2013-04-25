package entities;

import entities.Customer;
import entities.Employee;
import entities.Movie;
import entities.States;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T11:57:23")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, States> stateAbrv;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Customer> customer;
    public static volatile SingularAttribute<Person, Integer> accessLevel;
    public static volatile SingularAttribute<Person, String> password;
    public static volatile SingularAttribute<Person, String> city;
    public static volatile SingularAttribute<Person, String> email;
    public static volatile SingularAttribute<Person, String> address;
    public static volatile SingularAttribute<Person, String> zipCode;
    public static volatile SingularAttribute<Person, Integer> personId;
    public static volatile SingularAttribute<Person, Employee> employee;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> telephone;
    public static volatile CollectionAttribute<Person, Movie> movieCollection;

}