/**
 * PlanService.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;
import java.util.Map;

import co.ipicorp.saas.core.model.Plan;
import co.ipicorp.saas.core.model.PriceUnit;
import grass.micro.apps.service.GenericService;

/**
 * PlanService.
 * <<< Service related to {@link PlanService}.
 * @author ntduong
 * @access public
 */
public interface PlanService extends GenericService<Plan, Integer> {

    /**
     * Get {@link Plan} by given id.
     * @param id given id.
     * @return {@link Plan} instance.
     */
	PriceUnit getById(int id);
    
    /**
     * Get all {@link Plan}.
     * @return {@link List} of {@link Plan} instance.
     */
    List<Plan> getAll();
    
    /**
     * Get all available {@link Plan} (VALID and DRAFT status).
     * @return {@link List} of {@link Plan} instance.
     */
    List<Plan> getAllAvailable();

    List<Map<String, Object>> getAllPlanAndCountCustomer();

}
