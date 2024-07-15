/**
 * WardDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.ipicorp.saas.core.model.Ward;

/**
 * WardDao. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
public interface WardDao extends CrudRepository<Ward, Integer>, WardDaoCustomMethods {

	@Query("SELECT w FROM Ward w WHERE w.district.code = :districtCode")
	List<Ward> findByDistrictCode(@Param("districtCode") String districtCode);

	@Query("SELECT w FROM Ward w WHERE w.district.id = :districtId")
    List<Ward> findByDistrictId(@Param("districtId") int districtId);
}
