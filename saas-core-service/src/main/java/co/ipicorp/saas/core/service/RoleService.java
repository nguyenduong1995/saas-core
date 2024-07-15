/**
 * RoleService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.Role;
import grass.micro.apps.service.GenericService;

/**
 * RoleService. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
public interface RoleService extends GenericService<Role, Integer> {
    
    /**
     * Get activate {@link Role} by given roleName.
     * 
     * @param roleName
     * @return
     */
    Role getByRoleName(String roleName);

    List<Role> getAllAvailable();

}