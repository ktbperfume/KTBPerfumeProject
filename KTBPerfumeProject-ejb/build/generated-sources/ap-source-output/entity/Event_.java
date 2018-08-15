package entity;

import entity.Orderinfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, String> eventCode;
    public static volatile SingularAttribute<Event, String> name;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, Boolean> active;
    public static volatile SingularAttribute<Event, Double> discountpercent;
    public static volatile CollectionAttribute<Event, Orderinfo> orderinfoCollection;

}