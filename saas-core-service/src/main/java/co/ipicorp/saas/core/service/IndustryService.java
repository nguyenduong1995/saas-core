/**
 * IndustryService.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.Industry;
import grass.micro.apps.service.GenericService;

/**
 * IndustryService.
 * <<< Service related to {@link Industry}.
 * @author ntduong
 * @access public
 */
public interface IndustryService extends GenericService<Industry, Integer> {
    
    /**
     * Get List of {@link Industry} by given level.
     * @param level
     * @return {@link List} of {@link Industry} instances;
     */
    List<Industry> getActivatedByLevel(int level);
}
