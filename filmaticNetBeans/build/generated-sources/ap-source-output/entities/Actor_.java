package entities;

import entities.Actsin;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-29T21:47:14")
@StaticMetamodel(Actor.class)
public class Actor_ { 

    public static volatile CollectionAttribute<Actor, Actsin> actsinCollection;
    public static volatile SingularAttribute<Actor, Integer> actorId;
    public static volatile SingularAttribute<Actor, Integer> age;
    public static volatile SingularAttribute<Actor, String> gender;
    public static volatile SingularAttribute<Actor, Integer> rating;
    public static volatile SingularAttribute<Actor, String> actorName;

}