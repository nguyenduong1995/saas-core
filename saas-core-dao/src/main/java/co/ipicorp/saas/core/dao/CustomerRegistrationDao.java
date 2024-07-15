package co.ipicorp.saas.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.ipicorp.saas.core.model.CustomerRegistration;
import grass.micro.apps.model.base.Status;

/**
 * CustomerRegistrationDao. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
public interface CustomerRegistrationDao extends CrudRepository<CustomerRegistration, Integer>, CustomerRegistrationDaoCustomMethods {
	
	@Query("SELECT c FROM CustomerRegistration c WHERE c.id = :id")
	CustomerRegistration findById(@Param("id") int id);

	@Query("SELECT c FROM CustomerRegistration c WHERE c.email = :email")
	List<CustomerRegistration> findByEmail(@Param("email") String email);
	
	@Query("SELECT c FROM CustomerRegistration c WHERE c.status = :status")
	List<CustomerRegistration> findByStatusTwo(@Param("status") Status status);
	
}
