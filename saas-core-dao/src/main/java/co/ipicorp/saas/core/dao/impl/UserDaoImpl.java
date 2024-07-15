package co.ipicorp.saas.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.UserDaoCustomMethods;
import co.ipicorp.saas.core.model.User;
import co.ipicorp.saas.core.model.dto.UserSearchCondition;
import grass.micro.apps.model.dto.SearchCondition;

/**
 * 
 * UserDaoImpl. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDaoCustomMethods {

    @Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;

    @Override
    public List<User> search(SearchCondition condition) {
        UserSearchCondition userCondition = (UserSearchCondition) condition;
        String sql = "SELECT u FROM User u \n";
        if (userCondition.isEnableRoleId()) {
            sql += "JOIN u.roles r \n";
        }
        sql +="WHERE 1 = 1 \n";
        if (userCondition.isEnableLoginName()) {
            sql += "AND u.account.loginName LIKE CONCAT('%',:loginName,'%') \n";
        }
        if (userCondition.isEnableComanyId()) {
            sql += "AND u.company.id = :companyId \n";
        }
        if (userCondition.isEnableDepartmentId()) {
            sql += "AND u.department.id = :departmentId \n";
        }
        if (userCondition.isEnableFullName()) {
            sql += "AND u.fullName LIKE CONCAT('%',:fullName,'%') \n";
        }
        if (userCondition.isEnableMobile()) {
            sql += "AND u.mobile = :mobile \n";
        }
        if (userCondition.isEnableEmail()) {
            sql += "AND u.account.email LIKE CONCAT('%',:email,'%') \n";
        }
        if (userCondition.isEnableRoleId()) {
            sql += "AND r.id  = :roleId \n";
        }
        if (userCondition.isEnableStatus()) {
            sql += "AND u.status = :status \n";
        }
        sql += "AND u.status != grass.micro.apps.model.base.Status.DELETED";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        if (userCondition.isEnableLoginName()) {
            query.setParameter("loginName", userCondition.getLoginName());
        }
        if (userCondition.isEnableComanyId()) {
            query.setParameter("companyId", userCondition.getCompanyId());
        }
        if (userCondition.isEnableDepartmentId()) {
            query.setParameter("departmentId", userCondition.getDepartmentId());
        }
        if (userCondition.isEnableFullName()) {
            query.setParameter("fullName", userCondition.getFullName());
        }
        if (userCondition.isEnableMobile()) {
            query.setParameter("mobile", userCondition.getMobile());
        }
        if (userCondition.isEnableEmail()) {
            query.setParameter("email", userCondition.getEmail());
        }
        if (userCondition.isEnableRoleId()) {
            query.setParameter("roleId", userCondition.getRoleId());
        }
        if (userCondition.isEnableStatus()) {
            query.setParameter("status", userCondition.getStatus());
        }

        if (condition.isLimitSearch()) {
            query.setFirstResult(condition.getSegment());
            query.setMaxResults(condition.getOffset());
        }

        return (List<User>) query.getResultList();
    }
}
