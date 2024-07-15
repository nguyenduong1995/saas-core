package co.ipicorp.saas.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.StaffOfCustomerDaoCustomMethods;
import co.ipicorp.saas.core.model.StaffOfCustomer;
import co.ipicorp.saas.core.model.dto.StaffOfCustomerSearchCondition;
import grass.micro.apps.model.base.Status;

/**
 * 
 * StaffOfCustomerDaoImpl. <<< Detail note.
 * 
 * @author nguyeth
 * @access public
 */
@Repository
@Transactional
public class StaffOfCustomerDaoImpl implements StaffOfCustomerDaoCustomMethods {

    @Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;

	@Override
	public List<StaffOfCustomer> search(StaffOfCustomerSearchCondition customerSearchCondition) {
		String sql = "SELECT st FROM StaffOfCustomer st WHERE st.status != 9 ";
		
		if (customerSearchCondition.getStaffId() != null && customerSearchCondition.getStaffId().intValue() >= 0) {
			sql += "AND st.id != :staffId \n";
		}
		
		TypedQuery<StaffOfCustomer> query = entityManager.createQuery(sql, StaffOfCustomer.class);
		
		if (customerSearchCondition.getStaffId() != null && customerSearchCondition.getStaffId().intValue() >= 0) {
			query.setParameter("staffId", customerSearchCondition.getStaffId());
		}
		if (customerSearchCondition.isLimitSearch()) {
			query.setFirstResult(customerSearchCondition.getSegment());
			query.setMaxResults(customerSearchCondition.getOffset());	
		}
		List<StaffOfCustomer> result = (List<StaffOfCustomer>) query.getResultList();
		return result;
	}

	@Override
	public long count(StaffOfCustomerSearchCondition condition) {
		String sql = "SELECT COUNT(st) FROM StaffOfCustomer st WHERE 1 = 1 ";
		if (condition.getStaffId() != null && condition.getStaffId().intValue() >= 0) {
			sql += "AND st.id != :staffId \n";
		}
		
		if (condition.getStatus() != null && condition.getStatus().intValue() >= 0) {
			sql += "AND st.status = :status \n";
		}
		
		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		if (condition.getStaffId() != null && condition.getStaffId().intValue() >= 0) {
			query.setParameter("staffId", condition.getStaffId());
		}
		if (condition.getStatus() != null && condition.getStatus().intValue() >= 0) {
			query.setParameter("status", Status.fromValue(condition.getStatus()));
		}
		return query.getSingleResult();
	}

    
}
