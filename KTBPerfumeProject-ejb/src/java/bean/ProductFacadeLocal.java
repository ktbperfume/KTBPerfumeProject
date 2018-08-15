/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Brand;
import entity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MyPC
 */
@Local
public interface ProductFacadeLocal {

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();

    List<Product> searchName(String name);

    List<Product> sortDate();

    Product findProductById(String id);

    List<Product> getByBrand(Brand brand);    

    List<Product> getProductByPrice(int from, int to);
    
    List<Product> searchOilVolume(String oil);

    
    
    
}
