package entities;

import entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-01T09:08:47")
@StaticMetamodel(States.class)
public class States_ { 

    public static volatile SingularAttribute<States, String> stateAbrv;
    public static volatile SingularAttribute<States, String> state;
    public static volatile CollectionAttribute<States, Person> personCollection;

}