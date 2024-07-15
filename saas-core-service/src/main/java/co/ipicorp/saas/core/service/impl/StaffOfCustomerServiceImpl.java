/**
 * UserServiceImpl.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.StaffOfCustomerDao;
import co.ipicorp.saas.core.model.StaffOfCustomer;
import co.ipicorp.saas.core.model.dto.StaffOfCustomerSearchCondition;
import co.ipicorp.saas.core.service.StaffOfCustomerService;
import co.ipicorp.saas.core.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * UserServiceImpl.
 * <<< Implementation of {@link UserService}.
 * @author hieumicro
 * @access public
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class StaffOfCustomerServiceImpl extends GenericServiceImpl<StaffOfCustomer, Integer> implements StaffOfCustomerService {
    
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(StaffOfCustomerServiceImpl.class);

    @Autowired
    private StaffOfCustomerDao staffOfCustomerDao;
    
    @Override
    public List<StaffOfCustomer> search(SearchCondition condition) throws ServiceException {
        StaffOfCustomerSearchCondition customerSearchCondition = (StaffOfCustomerSearchCondition) condition;
        return this.staffOfCustomerDao.search(customerSearchCondition);
    }

    @Override
    public CrudRepository<StaffOfCustomer, Integer> getDao() {
        return this.staffOfCustomerDao;
    }

    @Override
    public List<StaffOfCustomer> getAllByCustomerId(Integer customerId) throws ServiceException {
        return this.staffOfCustomerDao.findByCustomerId(customerId);
    }

    @Override
    public StaffOfCustomer getByAccountId(int accountId) {
        return this.staffOfCustomerDao.findByAccountId(accountId);
    }

	@Override
	public long count(StaffOfCustomerSearchCondition condition) {
		return this.staffOfCustomerDao.count(condition);
	}

}
