/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Brand;
import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BrandFacade extends AbstractFacade<Brand> implements BrandFacadeLocal {
    @PersistenceContext(unitName = "KTBPerfumeProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BrandFacade() {
        super(Brand.class);
    }
    
    @Override
    public List<Product> showByBrand(Brand name){
        Query x = em.createQuery("SELECT p FROM Product p WHERE p.brandId = :name");
        x.setParameter("name", name);
        List<Product> list = x.getResultList();
        return list;
    }
    
}
