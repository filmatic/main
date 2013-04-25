package entities;

import entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-25T11:57:23")
@StaticMetamodel(States.class)
public class States_ { 

    public static volatile SingularAttribute<States, String> stateAbrv;
    public static volatile SingularAttribute<States, String> state;
    public static volatile CollectionAttribute<States, Person> personCollection;

}