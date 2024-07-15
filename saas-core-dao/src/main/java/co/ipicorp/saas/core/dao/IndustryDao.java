/**
 * IndustryDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.ipicorp.saas.core.model.Industry;
import grass.micro.apps.dao.base.PersistentCrudRepository;
import grass.micro.apps.model.base.Status;

/**
 * IndustryDao.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface IndustryDao extends PersistentCrudRepository<Industry, Integer>, IndustryDaoCustomMethods {
	
    @Query("SELECT u FROM Industry u WHERE u.id = :id")
    Industry findById(@Param("id") int id);
	
    @Override
    @Query("SELECT u FROM Industry u WHERE u.status = grass.micro.apps.model.base.Status.ACTIVE")
    List<Industry> findAllActivated();
    
    @Override
    @Query("SELECT u FROM Industry u WHERE u.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Industry> findAllAvailable();

    @Query("SELECT u FROM Industry u WHERE u.level = :level AND u.status IN (:statues)")
    List<Industry> findByLevelAndStatuses(@Param(value = "level") int level, @Param(value = "statues") List<Status> asList);
}
