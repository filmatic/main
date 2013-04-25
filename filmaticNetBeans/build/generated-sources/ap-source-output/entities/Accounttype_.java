package entities;

import entities.Customer;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T11:57:23")
@StaticMetamodel(Accounttype.class)
public class Accounttype_ { 

    public static volatile SingularAttribute<Accounttype, BigDecimal> monthlyFee;
    public static volatile SingularAttribute<Accounttype, Integer> moviesAtATime;
    public static volatile CollectionAttribute<Accounttype, Customer> customerCollection;
    public static volatile SingularAttribute<Accounttype, Integer> moviesPerMonth;
    public static volatile SingularAttribute<Accounttype, Integer> accountType;

}