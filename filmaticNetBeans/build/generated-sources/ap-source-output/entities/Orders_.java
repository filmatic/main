package entities;

import entities.Customer;
import entities.Employee;
import entities.Movie;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T12:52:22")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Employee> employeeId;
    public static volatile SingularAttribute<Orders, Movie> movieId;
    public static volatile SingularAttribute<Orders, Customer> customerId;
    public static volatile SingularAttribute<Orders, Integer> currentlyOut;
    public static volatile SingularAttribute<Orders, Date> dateTime;
    public static volatile SingularAttribute<Orders, Integer> pending;
    public static volatile SingularAttribute<Orders, Date> returnDate;
    public static volatile SingularAttribute<Orders, Integer> orderId;

}