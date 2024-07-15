/**
 * WardService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import co.ipicorp.saas.core.model.Ward;

import java.util.List;

import grass.micro.apps.service.GenericService;

/**
 * WardService.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface WardService extends GenericService<Ward, Integer> {

	List<Ward> getByDistrictCode(String districtCode);

    List<Ward> getByDistrictId(Integer districtId);
}
