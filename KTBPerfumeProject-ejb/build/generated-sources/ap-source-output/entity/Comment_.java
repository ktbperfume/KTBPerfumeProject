package entity;

import entity.Customer;
import entity.Product;
import entity.UserAdmin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Date> date;
    public static volatile SingularAttribute<Comment, String> previousId;
    public static volatile SingularAttribute<Comment, Product> productId;
    public static volatile SingularAttribute<Comment, String> subject;
    public static volatile SingularAttribute<Comment, Integer> rating;
    public static volatile SingularAttribute<Comment, Customer> customerId;
    public static volatile SingularAttribute<Comment, String> commentId;
    public static volatile SingularAttribute<Comment, String> content;
    public static volatile SingularAttribute<Comment, UserAdmin> username;

}