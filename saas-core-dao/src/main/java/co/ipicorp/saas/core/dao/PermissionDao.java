/**
 * 
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ipicorp.saas.core.model.Permission;

/**
 * @author hieu.vo
 *
 */
public interface PermissionDao extends JpaRepository<Permission, Integer>, PermissionDaoCustomMethods {

}
