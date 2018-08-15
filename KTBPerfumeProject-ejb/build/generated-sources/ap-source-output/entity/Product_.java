package entity;

import entity.Brand;
import entity.Comment;
import entity.Orderdetail;
import entity.Wishlist;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> image;
    public static volatile SingularAttribute<Product, String> country;
    public static volatile SingularAttribute<Product, Date> dateAddProduct;
    public static volatile SingularAttribute<Product, String> productId;
    public static volatile CollectionAttribute<Product, Comment> commentCollection;
    public static volatile CollectionAttribute<Product, Orderdetail> orderdetailCollection;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile CollectionAttribute<Product, Wishlist> wishlistCollection;
    public static volatile SingularAttribute<Product, String> volumeOfPerfumeOil;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Integer> yearIssue;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile SingularAttribute<Product, Double> averageRating;
    public static volatile SingularAttribute<Product, Brand> brandId;
    public static volatile SingularAttribute<Product, String> sizeOfBottle;
    public static volatile SingularAttribute<Product, String> forGender;

}