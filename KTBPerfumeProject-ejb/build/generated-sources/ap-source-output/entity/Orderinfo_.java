package entity;

import entity.Customer;
import entity.Event;
import entity.Orderdetail;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Orderinfo.class)
public class Orderinfo_ { 

    public static volatile SingularAttribute<Orderinfo, Date> date;
    public static volatile SingularAttribute<Orderinfo, Event> eventCode;
    public static volatile SingularAttribute<Orderinfo, Double> total;
    public static volatile SingularAttribute<Orderinfo, String> deliveryTo;
    public static volatile SingularAttribute<Orderinfo, String> mobile;
    public static volatile SingularAttribute<Orderinfo, Customer> customerId;
    public static volatile CollectionAttribute<Orderinfo, Orderdetail> orderdetailCollection;
    public static volatile SingularAttribute<Orderinfo, String> paymentMethod;
    public static volatile SingularAttribute<Orderinfo, String> orderCode;
    public static volatile SingularAttribute<Orderinfo, Boolean> status;

}