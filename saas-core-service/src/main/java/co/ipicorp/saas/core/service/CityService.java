/**
 * CityService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import co.ipicorp.saas.core.model.City;

import java.util.List;

import grass.micro.apps.service.GenericService;

/**
 * CityService.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public interface CityService extends GenericService<City, Integer> {

    City getByCode(String code);

    List<City> getByRegionId(int regionId);

}
