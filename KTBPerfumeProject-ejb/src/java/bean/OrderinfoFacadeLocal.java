/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Orderinfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MyPC
 */
@Local
public interface OrderinfoFacadeLocal {

    void create(Orderinfo orderinfo);

    void edit(Orderinfo orderinfo);

    void remove(Orderinfo orderinfo);

    Orderinfo find(Object id);

    List<Orderinfo> findAll();

    List<Orderinfo> findRange(int[] range);

    int count();
    
}
