package entity;

import entity.Orderinfo;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Orderdetail.class)
public class Orderdetail_ { 

    public static volatile SingularAttribute<Orderdetail, Integer> quantity;
    public static volatile SingularAttribute<Orderdetail, String> orderDetailCode;
    public static volatile SingularAttribute<Orderdetail, Product> productId;
    public static volatile SingularAttribute<Orderdetail, Orderinfo> orderCode;

}