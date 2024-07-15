/**
 * PermissionServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.PermissionDao;
import co.ipicorp.saas.core.model.Permission;
import co.ipicorp.saas.core.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * PermissionServiceImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Integer> implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public CrudRepository<Permission, Integer> getDao() {
        return this.permissionDao;
    }

    @Override
    public List<Permission> search(SearchCondition condition) throws ServiceException {
        return null;
    }

}
