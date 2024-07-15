/**
 * PlanDaoImpl.java
 * @copyright��Copyright � 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.PlanDaoCustomMethods;

/**
 * PlanDaoImpl.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
@Repository
@Transactional
public class PlanDaoImpl implements PlanDaoCustomMethods {
    @Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    @Override
	public List<Map<String, Object>> findAllPlanAndCountCustomer() {
		String sql = "SELECT pl.`id`, pl.`name`, pl.`description`, pl.`is_customize`, pl.`is_public`, pl.`status`, \n"
				+ "(SELECT COUNT(custP.id) from `td_customer_plan` custP WHERE pl.`id` = custP.`plan_id`) as count \n"
                + "FROM `t_plan` pl \n"
                + "WHERE pl.`status` != 9 ";
        
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> result = query.getResultList();
        return this.fetchItems(result);
	}
    
    /**
     * @param result
     * @return
     */
    private List<Map<String, Object>> fetchItems(List<Object[]> items) {
        List<Map<String, Object>> result = new LinkedList<Map<String,Object>>();
        for (Object[] item : items) {
            Map<String, Object> map = fetchItem(item);
            result.add(map);
        }
        return result;
    }

    /**
     * @param item
     * @return
     */
    private Map<String, Object> fetchItem(Object[] item) {
    	int index = 0;
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("id", Integer.parseInt(item[index++].toString()));
        result.put("name", item[index++].toString());
        result.put("description", item[index++].toString());
        result.put("isCustomize", Boolean.parseBoolean(item[index++].toString()) ? 1 : 0);
        result.put("isPublic", Boolean.parseBoolean(item[index++].toString()) ? 1 : 0);
        result.put("status", Integer.parseInt(item[index++].toString()));
        result.put("count", Integer.parseInt(item[index++].toString()));
        return result;
    }
    
}
