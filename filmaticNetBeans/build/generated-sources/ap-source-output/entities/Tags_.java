package entities;

import entities.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T11:57:23")
@StaticMetamodel(Tags.class)
public class Tags_ { 

    public static volatile SingularAttribute<Tags, Integer> movieId;
    public static volatile SingularAttribute<Tags, Movie> movie;
    public static volatile SingularAttribute<Tags, String> tagWord;

}