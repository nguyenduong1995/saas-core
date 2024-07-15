/**
 * RegionDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import co.ipicorp.saas.core.model.Region;

import org.springframework.data.repository.CrudRepository;

/**
 * RegionDao. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
public interface RegionDao extends CrudRepository<Region, Integer>, RegionDaoCustomMethods {
    
}
