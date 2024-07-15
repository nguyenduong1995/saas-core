/**
 * CustomerService.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.io.Reader;
import java.util.List;

import co.ipicorp.saas.core.model.Customer;
import grass.micro.apps.service.GenericService;

/**
 * CustomerService.
 * <<< Service related to {@link Customer}.
 * @author hieumicro
 * @access public
 */
public interface CustomerService extends GenericService<Customer, Integer> {
	/**
     * Get {@link Customer} by given id.
     * @param id given id.
     * @return {@link Customer} instance.
     */
    Customer getById(int id);
    
    Customer getByAccountId(int id);

    /**
     * Get {@link Customer} instance by given technicalEmail.
     * @param technicalEmail given Technical Email.
     * @return {@link Customer} instance.
     */
    Customer getByTechnicalEmail(String technicalEmail);
    /**
     * Get {@link Customer} instance by given shortName.
     * @param shortName given Short Name.
     * @return {@link Customer} instance.
     */
    Customer getByShortName(String shortName);
    
    /**
     * Get all available {@link Customer} (VALID and DRAFT status).
     * @return {@link List} of {@link Customer} instance.
     */
    List<Customer> getAllAvailable();
    
    void createDatabase(String dbName, Reader dumpFile);
}