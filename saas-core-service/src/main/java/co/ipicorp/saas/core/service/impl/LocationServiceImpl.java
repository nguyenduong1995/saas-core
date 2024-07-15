/**
 * LocationServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.model.City;
import co.ipicorp.saas.core.model.District;
import co.ipicorp.saas.core.model.Ward;
import co.ipicorp.saas.core.service.CityService;
import co.ipicorp.saas.core.service.DistrictService;
import co.ipicorp.saas.core.service.LocationService;
import co.ipicorp.saas.core.service.WardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LocationServiceImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Service
public class LocationServiceImpl implements LocationService {
    
    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private WardService wardService;
    
    @Override
    public String generateFullAddress(String address, int wardId, int districtId, int cityId) {
        City city = this.cityService.get(cityId);
        District district = this.districtService.get(districtId);
        Ward ward = this.wardService.get(wardId);
        StringBuilder result = new StringBuilder(address);
        
        if (ward != null) {
            result.append(", ").append(ward.getName());
        }
        
        if (district != null) {
            result.append(", ").append(district.getName());
        }
        
        if (city != null) {
            result.append(", ").append(city.getName());
        }
        
        return result.toString();
    }

}
