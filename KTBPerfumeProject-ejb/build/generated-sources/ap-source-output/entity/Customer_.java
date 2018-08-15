package entity;

import entity.Comment;
import entity.Feedback;
import entity.Orderinfo;
import entity.Wishlist;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> gender;
    public static volatile CollectionAttribute<Customer, Comment> commentCollection;
    public static volatile CollectionAttribute<Customer, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Customer, String> mobile;
    public static volatile SingularAttribute<Customer, String> fullName;
    public static volatile CollectionAttribute<Customer, Wishlist> wishlistCollection;
    public static volatile SingularAttribute<Customer, Date> dateOfBirth;
    public static volatile SingularAttribute<Customer, String> avatar;
    public static volatile CollectionAttribute<Customer, Orderinfo> orderinfoCollection;
    public static volatile SingularAttribute<Customer, String> password;
    public static volatile SingularAttribute<Customer, String> customerId;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Boolean> status;

}