package entity;

import entity.Customer;
import entity.UserAdmin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Date> date;
    public static volatile SingularAttribute<Feedback, String> subject;
    public static volatile SingularAttribute<Feedback, Customer> customerId;
    public static volatile SingularAttribute<Feedback, String> feedbackId;
    public static volatile SingularAttribute<Feedback, String> reply;
    public static volatile SingularAttribute<Feedback, String> content;
    public static volatile SingularAttribute<Feedback, String> status;
    public static volatile SingularAttribute<Feedback, UserAdmin> username;

}