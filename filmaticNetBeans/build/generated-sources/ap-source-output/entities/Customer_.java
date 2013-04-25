package entities;

import entities.Accounttype;
import entities.Orders;
import entities.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T11:57:23")
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