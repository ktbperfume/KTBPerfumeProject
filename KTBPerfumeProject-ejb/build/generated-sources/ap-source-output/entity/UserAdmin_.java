package entity;

import entity.Comment;
import entity.Feedback;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-08-14T15:57:19")
@StaticMetamodel(UserAdmin.class)
public class UserAdmin_ { 

    public static volatile SingularAttribute<UserAdmin, String> password;
    public static volatile SingularAttribute<UserAdmin, String> role;
    public static volatile CollectionAttribute<UserAdmin, Comment> commentCollection;
    public static volatile CollectionAttribute<UserAdmin, Feedback> feedbackCollection;
    public static volatile SingularAttribute<UserAdmin, String> fullName;
    public static volatile SingularAttribute<UserAdmin, String> avatar;
    public static volatile SingularAttribute<UserAdmin, String> email;
    public static volatile SingularAttribute<UserAdmin, String> username;
    public static volatile SingularAttribute<UserAdmin, Boolean> status;

}