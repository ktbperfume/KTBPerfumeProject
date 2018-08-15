package bean;

import entity.Wishlist;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MyPC
 */
@Stateless
public class WishlistFacade extends AbstractFacade<Wishlist> implements WishlistFacadeLocal {
    @PersistenceContext(unitName = "KTBPerfumeProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WishlistFacade() {
        super(Wishlist.class);
    }

    @Override
    public List<Wishlist> findByCusID(String cusID) {
        Query q = em.createQuery("SELECT w FROM Wishlist w WHERE w.customerId = :customerId");
        q.setParameter("customerId", cusID);
        return q.getResultList();
    }
    
    @Override
    public List<Wishlist> findByProID(String proID) {
        Query q = em.createQuery("SELECT w FROM Wishlist w WHERE w.productId = :productId");
        q.setParameter("productId", proID);
        return q.getResultList();
    }
    
    
}
