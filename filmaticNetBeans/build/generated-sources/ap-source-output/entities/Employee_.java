package entities;

import entities.Orders;
import entities.Person;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-29T21:47:14")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Integer> employeeId;
    public static volatile SingularAttribute<Employee, String> employeeType;
    public static volatile SingularAttribute<Employee, Date> startDate;
    public static volatile SingularAttribute<Employee, BigDecimal> hourlyRate;
    public static volatile SingularAttribute<Employee, Integer> transactionsManaged;
    public static volatile SingularAttribute<Employee, Person> person;
    public static volatile SingularAttribute<Employee, String> ssn;
    public static volatile CollectionAttribute<Employee, Orders> ordersCollection;

}