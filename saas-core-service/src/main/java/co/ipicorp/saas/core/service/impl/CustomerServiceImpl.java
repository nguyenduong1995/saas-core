/**
 * CustomerServiceImpl.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.CustomerDao;
import co.ipicorp.saas.core.model.Customer;
import co.ipicorp.saas.core.model.dto.CustomerSearchCondition;
import co.ipicorp.saas.core.service.CustomerService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * CustomerServiceImpl.
 * <<< Implementation of {@link CustomerService}.
 * @author hieumicro
 * @access public
 */
@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Integer> implements CustomerService {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDao customerDao;

	@Override
	public CrudRepository<Customer, Integer> getDao() {
		return this.customerDao;
	}

	@Override
	public List<Customer> search(SearchCondition condition) throws ServiceException {
		CustomerSearchCondition customerSearch = (CustomerSearchCondition) condition;
		return customerDao.search(customerSearch);
	}

	@Override
	public Customer getById(int id) {
		try {
            return this.customerDao.findById(id);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}

	@Override
	public Customer getByAccountId(int id) {
		try {
            return this.customerDao.findByAccountId(id);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}

    @Override
    public Customer getByTechnicalEmail(String technicalEmail) {
        try {
            return this.customerDao.findByEmail(technicalEmail);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

	@Override
	public Customer getByShortName(String shortName) {
		try {
            return this.customerDao.findByShortName(shortName);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}
	
	@Override
	public List<Customer> getAllAvailable() {
		try {
            return (List<Customer>) this.customerDao.findAllAvailable();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}

	@Override
	public void createDatabase(String dbName, Reader dumpFile) {
		this.customerDao.createDatabase(dbName, dumpFile);	
	}
}
