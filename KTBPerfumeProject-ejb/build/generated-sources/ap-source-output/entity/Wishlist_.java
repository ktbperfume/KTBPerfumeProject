package entity;

import entity.Customer;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Wishlist.class)
public class Wishlist_ { 

    public static volatile SingularAttribute<Wishlist, Product> productId;
    public static volatile SingularAttribute<Wishlist, Customer> customerId;
    public static volatile SingularAttribute<Wishlist, String> wishlistId;

}