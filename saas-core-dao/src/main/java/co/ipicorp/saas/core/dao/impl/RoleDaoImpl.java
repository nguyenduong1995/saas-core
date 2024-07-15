/**
 * 
 */
package co.ipicorp.saas.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.RoleDaoCustomMethods;
import co.ipicorp.saas.core.model.Role;
import co.ipicorp.saas.core.model.dto.RoleSearchCondition;
import grass.micro.apps.model.dto.SearchCondition;

/**
 * 
 * RoleDaoImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Repository
@Transactional
public class RoleDaoImpl implements RoleDaoCustomMethods {
    @Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;
    @Override
    public List<Role> search(SearchCondition condition) {
        RoleSearchCondition roleCondition = (RoleSearchCondition) condition;
        String sql = "SELECT r FROM Role r WHERE 1 = 1 \n";
        if (roleCondition.isEnableRoleName()) {
            sql += "AND r.roleName LIKE CONCAT('%',:roleName,'%') \n";
        }
        
        if (roleCondition.isEnableStatus()) {
            sql += "AND r.status = :status \n";
        }
        sql += "AND r.status != grass.micro.apps.model.base.Status.DELETED" ;
        TypedQuery<Role> query = entityManager.createQuery(sql, Role.class);
        if (roleCondition.isEnableRoleName()) {
            query.setParameter("roleName", roleCondition.getRoleName());
        }
        
        if (roleCondition.isEnableStatus()) {
            query.setParameter("status", roleCondition.getStatus());
        }

        if (condition.isLimitSearch()) {
            query.setFirstResult(condition.getSegment());
            query.setMaxResults(condition.getOffset());
        }

        return (List<Role>) query.getResultList();
    }

}
