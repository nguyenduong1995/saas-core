/**
 * CustomerMetadataDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     nt.duong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.ipicorp.saas.core.model.CustomerMetadata;
import co.ipicorp.saas.core.model.CustomerMetakeyType;

/**
 * CustomerMetadataDao.
 * <<< Detail note.
 * @author nt.duong
 * @access public
 */
public interface CustomerMetadataDao extends CrudRepository<CustomerMetadata, Integer>, CustomerMetadataDaoCustomMethods {
	
	@Query("SELECT cust FROM CustomerMetadata cust WHERE cust.customerId = :customerId")
    List<CustomerMetadata> findAllByCustomerId(@Param("customerId") Integer customerId);

	@Query("SELECT cust FROM CustomerMetadata cust WHERE cust.metaKeyType = :keyType \n"
	        + "AND cust.metaKey = :key AND cust.textContent = :value")
    CustomerMetadata findByTextKeyValue(@Param("keyType") CustomerMetakeyType keyType, @Param("key") String key, @Param("value") String value);

	@Query("SELECT cust FROM CustomerMetadata cust WHERE cust.customerId = :customerId AND cust.metaKey = :key")
    CustomerMetadata findByCustomerIdAndKey(@Param("customerId") int customerId, @Param("key") String key);
	
}
