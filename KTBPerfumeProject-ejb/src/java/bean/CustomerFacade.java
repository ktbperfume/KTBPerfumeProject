package bean;

import entity.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MyPC
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "KTBPerfumeProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public Customer Login(String email, String pass) {
        Customer c = new Customer();
        try {
            Query query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email and c.password = :password");
            query.setParameter("email", email);
            query.setParameter("password", pass);
            c = (Customer) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            c = null;
        }

        return c;
    }

    @Override
    public boolean isExistedEmail(String email) {
        try {
            Query q = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email");
            q.setParameter("email", email);
            return q.getSingleResult() != null;
        } catch (NoResultException e) {
            return false;
        }
        
    }

    @Override
    public boolean checkPassword(String pass) {
        try {
            Query q = em.createQuery("SELECT c FROM Customer c WHERE c.password = :password");
        q.setParameter("password", pass);
        return q.getSingleResult() != null;
        } catch (NoResultException e) {
            return false;
        }
        
        
    }
    
    

    
    
    
    
    
    
    
    
}
