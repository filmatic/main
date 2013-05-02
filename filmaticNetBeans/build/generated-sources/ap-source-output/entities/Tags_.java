package entities;

import entities.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-01T20:46:13")
@StaticMetamodel(Tags.class)
public class Tags_ { 

    public static volatile SingularAttribute<Tags, Integer> movieId;
    public static volatile SingularAttribute<Tags, Movie> movie;
    public static volatile SingularAttribute<Tags, String> tagWord;

}