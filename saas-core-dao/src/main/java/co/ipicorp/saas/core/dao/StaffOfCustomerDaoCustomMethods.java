package co.ipicorp.saas.core.dao;

import java.util.List;

import co.ipicorp.saas.core.model.StaffOfCustomer;
import co.ipicorp.saas.core.model.dto.StaffOfCustomerSearchCondition;

/**
 * 
 * StaffOfCustomerDaoCustomMethods.
 * <<< Detail note.
 * @author thuy nguyen
 * @access public
 */
public interface StaffOfCustomerDaoCustomMethods {
	List<StaffOfCustomer> search(StaffOfCustomerSearchCondition customerSearchCondition);
	long count(StaffOfCustomerSearchCondition condition);
}
