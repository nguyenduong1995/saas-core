/**
 * CompanyServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.ipicorp.saas.core.dao.CustomerRegistrationDao;
import co.ipicorp.saas.core.model.CustomerRegistration;
import co.ipicorp.saas.core.service.CustomerRegistrationService;
import grass.micro.apps.model.base.Status;
import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * CustomerRegistrationServiceImpl.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
@Service
public class CustomerRegistrationServiceImpl extends GenericServiceImpl<CustomerRegistration, Integer> implements CustomerRegistrationService {
    
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(CustomerRegistrationServiceImpl.class);

    @Autowired
    private CustomerRegistrationDao registrationDao;

    @Override
	public CrudRepository<CustomerRegistration, Integer> getDao() {
		return this.registrationDao;
	}

    @Override
    public List<CustomerRegistration> search(SearchCondition condition) throws ServiceException {
        return null;
    }

	@Override
	public CustomerRegistration getById(int id) {
		try {
            return this.registrationDao.findById(id);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}

	@Override
	public List<CustomerRegistration> getByEmail(String email) {
		try {
            return this.registrationDao.findByEmail(email);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}

	@Override
	public List<CustomerRegistration> getByStatusTwo(Status status) {
		try {
            return this.registrationDao.findByStatusTwo(status);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}
    
}    
