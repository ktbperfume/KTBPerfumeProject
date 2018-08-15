package bean;

import entity.Orderdetail;
import entity.Orderinfo;
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
public class OrderdetailFacade extends AbstractFacade<Orderdetail> implements OrderdetailFacadeLocal {

    @PersistenceContext(unitName = "KTBPerfumeProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderdetailFacade() {
        super(Orderdetail.class);
    }

    @Override
    public List<Orderdetail> searchByInfoOrder(Orderinfo orderInfo) {

        Query x = em.createQuery("SELECT o FROM Orderdetail o WHERE o.orderCode = :name");
        x.setParameter("name", orderInfo);
        List<Orderdetail> list = x.getResultList();
        return list;
    }

}
