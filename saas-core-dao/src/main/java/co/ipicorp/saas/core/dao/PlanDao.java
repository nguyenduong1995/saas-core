/**
 * PlanDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;

import co.ipicorp.saas.core.model.Plan;
import grass.micro.apps.dao.base.PersistentCrudRepository;

/**
 * PlanDao.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface PlanDao extends PersistentCrudRepository<Plan, Integer>, PlanDaoCustomMethods {
    @Override
    @Query("SELECT u FROM Plan u WHERE u.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<Plan> findAllActivated();
    
    @Override
    @Query("SELECT u FROM Plan u WHERE u.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Plan> findAllAvailable();
}
