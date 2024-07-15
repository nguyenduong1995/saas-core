/**
 * CityDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import co.ipicorp.saas.core.model.City;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CityDao. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
public interface CityDao extends CrudRepository<City, Integer>, CityDaoCustomMethods {
    
    @Query(value = "SELECT c FROM City c WHERE c.regionId = :regionId")
    List<City> findByRegionId(@Param(value = "regionId") int regionId);
    
    @Query(value = "SELECT c FROM City c WHERE c.code = :code")
    City findByCode(@Param(value = "code") String code);

}
