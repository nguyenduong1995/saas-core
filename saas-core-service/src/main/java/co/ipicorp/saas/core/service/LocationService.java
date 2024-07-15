/**
 * LocationService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

/**
 * LocationService.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public interface LocationService {
    String generateFullAddress(String address, int wardId, int districtId, int cityId);
}
