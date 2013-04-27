package entities;

import entities.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T12:52:22")
@StaticMetamodel(Actor.class)
public class Actor_ { 

    public static volatile SingularAttribute<Actor, Integer> actorId;
    public static volatile SingularAttribute<Actor, Integer> age;
    public static volatile SingularAttribute<Actor, String> gender;
    public static volatile SingularAttribute<Actor, Integer> rating;
    public static volatile SingularAttribute<Actor, String> actorName;
    public static volatile CollectionAttribute<Actor, Movie> movieCollection;

}