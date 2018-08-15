package bean;

import entity.Brand;
import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {
    @PersistenceContext(unitName = "KTBPerfumeProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public Product findProductById(String id) {
        Query q = em.createNamedQuery("Product.findByProductId");
        q.setParameter("productId", id);
        Product pro=(Product) q.setMaxResults(1).getSingleResult();
        return pro;
    }
    
    @Override
    public List<Product> searchName(String name) {
        Query q = em.createQuery("SELECT p FROM Product p WHERE p.productName LIKE :productName ORDER BY p.dateAddProduct DESC");
        q.setParameter("productName", "%"+name+"%");
        return q.getResultList();
    }

    @Override
    public List<Product> sortDate() {
        Query q = em.createQuery("SELECT p FROM Product p ORDER BY p.dateAddProduct DESC");
        return q.getResultList();
    }

    @Override
    public List<Product> getByBrand(Brand brand) {
        Query q = em.createQuery("SELECT p FROM Product p WHERE p.brandId = :brand");
        q.setParameter("brand", brand);
        return q.getResultList();
    }

    @Override
    public List<Product> getProductByPrice(int from, int to) {
        Query q = em.createQuery("SELECT p FROM Product p WHERE p.price >= :from AND p.price <= :to ORDER BY p.price DESC");
        q.setParameter("from", from);
        q.setParameter("to", to);
        return q.getResultList();
    }
    
    @Override
    public List<Product> searchOilVolume(String oil) {
        Query q = em.createQuery("SELECT p FROM Product p WHERE p.volumeOfPerfumeOil = :volumeOfPerfumeOil ORDER BY p.dateAddProduct DESC");
        q.setParameter("volumeOfPerfumeOil", oil);
        return q.getResultList();
    }

    
    
    
    
    

    
    
    

    
    
    
    
    
    
}
