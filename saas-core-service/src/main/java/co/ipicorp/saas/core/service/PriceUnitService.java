/**
 * PriceUnitService.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.PriceUnit;
import grass.micro.apps.service.GenericService;

/**
 * PriceUnitService.
 * <<< Service related to {@link PriceUnitService}.
 * @author ntduong
 * @access public
 */
public interface PriceUnitService extends GenericService<PriceUnit, Integer> {

    /**
     * Get {@link PriceUnit} by given id.
     * @param id given id.
     * @return {@link PriceUnit} instance.
     */
	PriceUnit getById(int id);
    
    /**
     * Get all {@link PriceUnit}.
     * @return {@link List} of {@link PriceUnit} instance.
     */
    List<PriceUnit> getAll();
    
    /**
     * Get all available {@link PriceUnit} (VALID and DRAFT status).
     * @return {@link List} of {@link PriceUnit} instance.
     */
    List<PriceUnit> getAllAvailable();


}
