/**
 * StaffServiceImpl.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.StaffDao;
import co.ipicorp.saas.core.model.Staff;
import co.ipicorp.saas.core.service.StaffService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import grass.micro.apps.model.base.Status;
import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * StaffServiceImpl.
 * <<< Implementation of {@link StaffService}.
 * @author hieumicro
 * @access public
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class StaffServiceImpl extends GenericServiceImpl<Staff, Integer> implements StaffService {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(StaffServiceImpl.class);

    @Autowired
    private StaffDao StaffDao;
    
    @Override
    public CrudRepository<Staff, Integer> getDao() {
        return this.StaffDao;
    }
    
    @Override
    public Staff getById(int id) {
        try {
            return this.StaffDao.findById(id);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Staff> getAll() {
        try {
            return this.StaffDao.findAll();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<Staff> getAllAvailable() {
        try {
            return this.StaffDao.findAllByStatus(Arrays.asList(Status.ACTIVE, Status.INACTIVE));
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

	@Override
    public Staff getByAccountId(int accountId) {
	    try {
            return this.StaffDao.findByAccountId(accountId);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
	public List<Staff> search(SearchCondition condition) throws ServiceException {
        return null;
	}

}
