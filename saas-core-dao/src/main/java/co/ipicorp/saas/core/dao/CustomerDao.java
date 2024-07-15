package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grass.micro.apps.dao.base.PersistentCrudRepository;
import co.ipicorp.saas.core.model.Customer;

public interface CustomerDao extends PersistentCrudRepository<Customer, Integer>, CustomerDaoCustomMethods {
	@Override
    @Query("SELECT c FROM Customer c WHERE c.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<Customer> findAllActivated();
	
	@Override
    @Query("SELECT c FROM Customer c WHERE c.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Customer> findAllAvailable();
	
	@Query("SELECT c FROM Customer c LEFT JOIN c.account a WHERE a.id = :accountId"
			+ " AND c.status = grass.micro.apps.model.base.Status.ACTIVE")
    Customer findByAccountId(@Param("accountId") int accountId);
	
	@Query("SELECT c FROM Customer c WHERE c.id = :id")
    Customer findById(@Param("id") int id);

	@Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(@Param("email") String email);

	@Query("SELECT c FROM Customer c WHERE c.shortname = :shortName")
	Customer findByShortName(@Param("shortName") String shortName);
}
