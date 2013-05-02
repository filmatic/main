package entities;

import entities.Actor;
import entities.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-01T20:46:13")
@StaticMetamodel(Actsin.class)
public class Actsin_ { 

    public static volatile SingularAttribute<Actsin, Movie> movieId;
    public static volatile SingularAttribute<Actsin, Actor> actorId;
    public static volatile SingularAttribute<Actsin, Integer> actsInId;

}