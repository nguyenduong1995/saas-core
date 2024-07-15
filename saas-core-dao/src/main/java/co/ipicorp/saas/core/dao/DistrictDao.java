/**
 * DistrictDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.ipicorp.saas.core.model.District;

/**
 * DistrictDao. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
public interface DistrictDao extends CrudRepository<District, Integer>, DistrictDaoCustomMethods {

	@Query("SELECT d FROM District d WHERE d.city.code = :cityCode")
	List<District> findByCityCode(@Param("cityCode") String cityCode);

	@Query("SELECT d FROM District d WHERE d.city.id = :cityId")
    List<District> findByCityId(@Param("cityId") int cityId);
}
