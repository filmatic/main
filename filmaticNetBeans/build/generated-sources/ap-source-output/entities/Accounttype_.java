package entities;

import entities.Customer;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-01T09:08:47")
@StaticMetamodel(Accounttype.class)
public class Accounttype_ { 

    public static volatile SingularAttribute<Accounttype, BigDecimal> monthlyFee;
    public static volatile SingularAttribute<Accounttype, Integer> moviesAtATime;
    public static volatile CollectionAttribute<Accounttype, Customer> customerCollection;
    public static volatile SingularAttribute<Accounttype, Integer> moviesPerMonth;
    public static volatile SingularAttribute<Accounttype, Integer> accountType;

}