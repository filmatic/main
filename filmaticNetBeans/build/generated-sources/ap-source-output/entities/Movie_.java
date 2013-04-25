package entities;

import entities.Actor;
import entities.Orders;
import entities.Person;
import entities.Tags;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T11:57:23")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> genre;
    public static volatile SingularAttribute<Movie, Tags> tags;
    public static volatile SingularAttribute<Movie, Integer> movieId;
    public static volatile SingularAttribute<Movie, BigDecimal> distributionFee;
    public static volatile SingularAttribute<Movie, Integer> numberCopies;
    public static volatile SingularAttribute<Movie, Integer> timesRented;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile SingularAttribute<Movie, Integer> timesRated;
    public static volatile CollectionAttribute<Movie, Person> personCollection;
    public static volatile SingularAttribute<Movie, Integer> rating;
    public static volatile CollectionAttribute<Movie, Orders> ordersCollection;
    public static volatile SingularAttribute<Movie, String> imageLocation;
    public static volatile CollectionAttribute<Movie, Actor> actorCollection;

}