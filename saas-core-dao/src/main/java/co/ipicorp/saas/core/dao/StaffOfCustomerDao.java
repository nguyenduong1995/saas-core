package co.ipicorp.saas.core.dao;

import co.ipicorp.saas.core.model.StaffOfCustomer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import grass.micro.apps.dao.base.PersistentCrudRepository;
import grass.micro.apps.model.base.Status;

/**
 * 
 * StaffOfCustomerDao.
 * <<< Detail note.
 * @author thuy nguyen
 * @access public
 */
public interface StaffOfCustomerDao extends PersistentCrudRepository<StaffOfCustomer, Integer>, StaffOfCustomerDaoCustomMethods {
    
    @Override
    @Query("SELECT s FROM StaffOfCustomer s WHERE s.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<StaffOfCustomer> findAllActivated();
    
    @Override
    @Query("SELECT s FROM StaffOfCustomer s WHERE s.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<StaffOfCustomer> findAllAvailable();
    
    @Query("SELECT s FROM StaffOfCustomer s WHERE s.id = :id")
    StaffOfCustomer findById(@Param("id") int id);
    
    @Query("SELECT s FROM StaffOfCustomer s")
    List<StaffOfCustomer> findAll();
    
    @Query("SELECT s FROM StaffOfCustomer s WHERE s.status IN (:statusList)")
    List<StaffOfCustomer> findAllByStatus(@Param("statusList") List<Status> statusList);

    @Query("SELECT s FROM StaffOfCustomer s WHERE s.account.id = :accountId"
            + " AND s.status = grass.micro.apps.model.base.Status.ACTIVE")
    StaffOfCustomer findByAccountId(@Param("accountId") int accountId);
    
    @Query("SELECT s FROM StaffOfCustomer s WHERE s.customer.id = :customerId"
            + " AND s.status = grass.micro.apps.model.base.Status.ACTIVE")
    List<StaffOfCustomer> findByCustomerId(@Param("customerId") int customerId);
}
