/**
 * PlanDaoCustomMethods.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import java.util.List;
import java.util.Map;

/**
 * PlanDaoCustomMethods.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface PlanDaoCustomMethods {
	
	List<Map<String, Object>> findAllPlanAndCountCustomer();
}
