/**
 * DistrictService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import co.ipicorp.saas.core.model.District;

import java.util.List;

import grass.micro.apps.service.GenericService;

/**
 * DistrictService.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface DistrictService extends GenericService<District, Integer> {
	
	List<District> getAllByCityCode(String cityCode);

    List<District> getByCityId(int cityId);

}
