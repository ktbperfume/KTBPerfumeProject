package bean;

import entity.UserAdmin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MyPC
 */
@Stateless
public class UserAdminFacade extends AbstractFacade<UserAdmin> implements UserAdminFacadeLocal {
    @PersistenceContext(unitName = "KTBPerfumeProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAdminFacade() {
        super(UserAdmin.class);
    }
    
    @Override
    public UserAdmin login(String user, String password) {
        UserAdmin u = new UserAdmin();

        try {
            Query query = em.createQuery("SELECT u FROM UserAdmin u WHERE u.username = :username and u.password = :password");
            query.setParameter("username", user);
            query.setParameter("password", password);
            u = (UserAdmin) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            u = null;
        }

        return u;
    }
    
}
