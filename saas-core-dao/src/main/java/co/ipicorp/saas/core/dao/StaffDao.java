package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import grass.micro.apps.dao.base.PersistentCrudRepository;
import co.ipicorp.saas.core.model.Staff;
import grass.micro.apps.model.base.Status;
/**
 * 
 * StaffDao.
 * <<< Detail note.
 * @author thuy nguyen
 * @access public
 */
public interface StaffDao extends PersistentCrudRepository<Staff, Integer>, StaffDaoCustomMethods {
    
    @Override
    @Query("SELECT s FROM Staff s WHERE s.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<Staff> findAllActivated();
    
    @Override
    @Query("SELECT s FROM Staff s WHERE s.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Staff> findAllAvailable();
    
    @Query("SELECT s FROM Staff s WHERE s.id = :id")
    Staff findById(@Param("id") int id);
    
    @Query("SELECT s FROM Staff s")
    List<Staff> findAll();
    
    @Query("SELECT s FROM Staff s WHERE s.status IN (:statusList)")
	List<Staff> findAllByStatus(@Param("statusList") List<Status> statusList);

    @Query("SELECT s FROM Staff s WHERE s.account.id = :accountId"
            + " AND s.status = grass.micro.apps.model.base.Status.ACTIVE")
    Staff findByAccountId(@Param("accountId") int accountId);
}
