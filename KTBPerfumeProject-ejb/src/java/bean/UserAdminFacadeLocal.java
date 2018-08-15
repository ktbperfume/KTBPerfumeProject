/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.UserAdmin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MyPC
 */
@Local
public interface UserAdminFacadeLocal {

    void create(UserAdmin userAdmin);

    void edit(UserAdmin userAdmin);

    void remove(UserAdmin userAdmin);

    UserAdmin find(Object id);

    List<UserAdmin> findAll();

    List<UserAdmin> findRange(int[] range);

    int count();
    
    UserAdmin login(String user, String password);
    
}
