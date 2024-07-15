/**
 * RoleServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.PermissionDao;
import co.ipicorp.saas.core.dao.RoleDao;
import co.ipicorp.saas.core.model.Role;
import co.ipicorp.saas.core.model.dto.RoleSearchCondition;
import co.ipicorp.saas.core.service.RoleService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import grass.micro.apps.model.base.Status;
import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * RoleServiceImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {
    
    private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;
    
    @SuppressWarnings("unused")
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public CrudRepository<Role, Integer> getDao() {
        return this.roleDao;
    }

    @Override
    public Role getByRoleName(String roleName) {
        Role result = null;
        try {
           result = this.roleDao.findByRoleName(roleName);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return result;
    }

    @Override
    public List<Role> search(SearchCondition condition) throws ServiceException {
        RoleSearchCondition roleCondition = (RoleSearchCondition) condition;
        return this.roleDao.search(roleCondition);
    }

    @Override
    public List<Role> getAllAvailable() {
        try {
            return this.roleDao.findAllByStatus(Arrays.asList(Status.ACTIVE, Status.INACTIVE));
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}    
