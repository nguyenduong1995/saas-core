package co.ipicorp.saas.core.dao;

import co.ipicorp.saas.core.model.StaffRole;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * StaffRoleDao.
 * <<< Detail note.
 * @author thuy nguyen
 * @access public
 */
public interface StaffRoleDao extends CrudRepository<StaffRole, Integer>, StaffRoleDaoCustomMethods {
}
