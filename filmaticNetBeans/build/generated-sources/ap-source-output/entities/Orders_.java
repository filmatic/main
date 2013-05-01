package entities;

import entities.Customer;
import entities.Employee;
import entities.Movie;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-01T09:08:47")
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