/**
 * CompanyService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import co.ipicorp.saas.core.model.Company;
import grass.micro.apps.service.GenericService;

/**
 * CompanyService.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public interface CompanyService extends GenericService<Company, Integer> {
	
	/**
     * Get {@link Company} by given fullname.
     * @param id given fullname.
     * @return {@link Company} instance.
     */
	Company getByFullname(String fullname);
}
