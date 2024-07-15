/**
 * CompanyDaoCustomMethods.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import java.util.List;

import co.ipicorp.saas.core.model.CustomerRegistration;
//import grass.micro.apps.model.auth.CustomerRegistration;
import grass.micro.apps.model.dto.SearchCondition;

/**
 * CustomerRegistrationDaoCustomMethods.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface CustomerRegistrationDaoCustomMethods {

	List<CustomerRegistration> search(SearchCondition search);
}
