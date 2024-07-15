/**
 * CompanyDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grass.micro.apps.dao.base.PersistentCrudRepository;
import co.ipicorp.saas.core.model.Company;

/**
 * CompanyDao.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public interface CompanyDao extends PersistentCrudRepository<Company, Integer>, CompanyDaoCustomMethods {
    @Override
    @Query("SELECT u FROM Company u WHERE u.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<Company> findAllActivated();
    
    @Override
    @Query("SELECT u FROM Company u WHERE u.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Company> findAllAvailable();
    
    @Query("SELECT u FROM Company u WHERE u.fullname like :fullname")
    Company getByFullname(@Param("fullname") String fullname );
}
