/**
 * 
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import co.ipicorp.saas.core.model.Role;
import grass.micro.apps.model.base.Status;

/**
 * @author hieu.vo
 *
 */
public interface RoleDao extends JpaRepository<Role, Integer>, RoleDaoCustomMethods {

    @Query("SELECT r FROM Role r WHERE r.roleName = :roleName and r.status != grass.micro.apps.model.base.Status.DELETED ")
    Role findByRoleName(@Param(value = "roleName") String roleName);

    @Query("SELECT r FROM Role r WHERE r.status IN (:statusList)")
//    @Query(nativeQuery = true, value = "SELECT r FROM Role r WHERE r.status IN (:statusList)")
    List<Role> findAllByStatus(@Param("statusList") List<Status> statusList);
}
