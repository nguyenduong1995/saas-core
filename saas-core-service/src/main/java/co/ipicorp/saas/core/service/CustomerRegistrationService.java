/**
 * CompanyService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.CustomerRegistration;
import grass.micro.apps.model.base.Status;
import grass.micro.apps.service.GenericService;

/**
 * CustomerRegistrationService.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface CustomerRegistrationService extends GenericService<CustomerRegistration, Integer> {

	/**
     * Get {@link CustomerRegistration} by given id.
     * @param id given id.
     * @return {@link CustomerRegistration} instance.
     */
	CustomerRegistration getById(int id);
    

    /**
     * Get {@link CustomerRegistration} instance by given email.
     * @param email given Email.
     * @return {@link CustomerRegistration} instance.
     */
	List<CustomerRegistration> getByEmail(String email);
	
	/**
     * Get {@link CustomerRegistration} instance by given statusTwo.
     * @param statusTwo given statusTwo.
     * @return {@link CustomerRegistration} instance.
     */
	List<CustomerRegistration> getByStatusTwo(Status status);
}
