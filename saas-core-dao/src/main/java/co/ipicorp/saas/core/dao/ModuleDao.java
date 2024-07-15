/**
 * ModuleDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;

import co.ipicorp.saas.core.model.Module;
import grass.micro.apps.dao.base.PersistentCrudRepository;

/**
 * ModuleDao.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface ModuleDao extends PersistentCrudRepository<Module, Integer>, ModuleDaoCustomMethods {
    @Override
    @Query("SELECT u FROM Module u WHERE u.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<Module> findAllActivated();
    
    @Override
    @Query("SELECT u FROM Module u WHERE u.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Module> findAllAvailable();
}
