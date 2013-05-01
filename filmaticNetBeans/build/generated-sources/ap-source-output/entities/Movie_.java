package entities;

import entities.Actsin;
import entities.Orders;
import entities.Tags;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-01T09:08:47")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Tags> tags;
    public static volatile SingularAttribute<Movie, String> genre;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile CollectionAttribute<Movie, Actsin> actsinCollection;
    public static volatile SingularAttribute<Movie, Integer> movieId;
    public static volatile SingularAttribute<Movie, BigDecimal> distributionFee;
    public static volatile SingularAttribute<Movie, Integer> timesRated;
    public static volatile SingularAttribute<Movie, Integer> rating;
    public static volatile CollectionAttribute<Movie, Orders> ordersCollection;
    public static volatile SingularAttribute<Movie, String> imageLocation;
    public static volatile SingularAttribute<Movie, Integer> timesRented;
    public static volatile SingularAttribute<Movie, Integer> numberCopies;

}