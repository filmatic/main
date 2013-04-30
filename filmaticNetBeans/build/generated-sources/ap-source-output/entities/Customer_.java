package entities;

import entities.Accounttype;
import entities.Orders;
import entities.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-29T21:47:14")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Person> person;
    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile SingularAttribute<Customer, String> creditCardNumber;
    public static volatile SingularAttribute<Customer, Accounttype> accountType;
    public static volatile SingularAttribute<Customer, Date> accountCreationDate;
    public static volatile SingularAttribute<Customer, Integer> timesLoggedIn;
    public static volatile SingularAttribute<Customer, Integer> rating;
    public static volatile CollectionAttribute<Customer, Orders> ordersCollection;

}