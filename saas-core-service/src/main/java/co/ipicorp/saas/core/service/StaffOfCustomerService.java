/**
 * StaffOfCustomerService.java
 * @author     nguyeth
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.Staff;
import co.ipicorp.saas.core.model.StaffOfCustomer;
import co.ipicorp.saas.core.model.dto.StaffOfCustomerSearchCondition;
import grass.micro.apps.service.GenericService;
import grass.micro.apps.service.exception.ServiceException;

/**
 * StaffOfCustomerService.
 * <<< Service related to {@link Staff}.
 * @author nguyeth
 * @access public
 */
public interface StaffOfCustomerService extends GenericService<StaffOfCustomer, Integer> {
    
    List<StaffOfCustomer> getAllByCustomerId(Integer id) throws ServiceException;

    /**
     * Get {@link StaffOfCustomer} instance by given account id.
     * @param accountId given account id.
     * @return {@link StaffOfCustomer}
     */
    StaffOfCustomer getByAccountId(int accountId);

	long count(StaffOfCustomerSearchCondition condition);    
}
