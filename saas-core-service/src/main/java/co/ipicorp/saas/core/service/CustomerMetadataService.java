/**
 * CustomerMetadataService.java
 * @author     nt.duong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.CustomerMetadata;
import grass.micro.apps.service.GenericService;

/**
 * CustomerMetadataService.
 * <<< Service related to {@link CustomerMetadata}.
 * @author nt.duong
 * @access public
 */
public interface CustomerMetadataService extends GenericService<CustomerMetadata, Integer> {
	/**
     * Get {@link CustomerMetadata} by given customerId.
     * @param customerId given customerId.
     * @return {@link CustomerMetadata} instance.
     */
	List<CustomerMetadata> getByCustomerId(int customerId);
    
    Iterable<CustomerMetadata> saveAll (List<CustomerMetadata> customerMetadatas);

    /**
     * Get {@link CustomerMetadata} instance by given text key and text value
     * @param key 
     * @param value
     * @return {@link CustomerMetadata}
     */
    CustomerMetadata getByTextKeyValue(String key, String value);
    
    /**
     * Get {@link CustomerMetadata} by given customerId and key.
     * @param customerId
     * @param key
     * @return
     */
    CustomerMetadata getByCustomerIdAndKey(int customerId, String key);

}