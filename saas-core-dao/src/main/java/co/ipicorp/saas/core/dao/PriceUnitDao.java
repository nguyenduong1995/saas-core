/**
 * PriceUnitDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;

import co.ipicorp.saas.core.model.PriceUnit;
import grass.micro.apps.dao.base.PersistentCrudRepository;

/**
 * PriceUnitDao.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface PriceUnitDao extends PersistentCrudRepository<PriceUnit, Integer>, PriceUnitDaoCustomMethods {
    @Override
    @Query("SELECT p FROM PriceUnit p WHERE p.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<PriceUnit> findAllActivated();
    
    @Override
    @Query("SELECT u FROM PriceUnit u WHERE u.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<PriceUnit> findAllAvailable();
}
