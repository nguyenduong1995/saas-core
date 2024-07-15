/**
 * UserServiceImpl.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.UserDao;
import co.ipicorp.saas.core.model.User;
import co.ipicorp.saas.core.model.dto.UserSearchCondition;
import co.ipicorp.saas.core.service.UserService;

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
 * UserServiceImpl.
 * <<< Implementation of {@link UserService}.
 * @author hieumicro
 * @access public
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;
    
    @Override
    public CrudRepository<User, Integer> getDao() {
        return this.userDao;
    }
    
    @Override
    public User getById(int id) {
        try {
            return this.userDao.findById(id);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return this.userDao.findAll();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<User> getAllAvailable() {
        try {
            return this.userDao.findAllByStatus(Arrays.asList(Status.ACTIVE, Status.INACTIVE));
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

	@Override
    public User getByAccountId(int accountId) {
	    try {
            return this.userDao.findByAccountId(accountId);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
	public List<User> search(SearchCondition condition) throws ServiceException {
        UserSearchCondition userCondition = (UserSearchCondition) condition;
        return this.userDao.search(userCondition);
	}

}
