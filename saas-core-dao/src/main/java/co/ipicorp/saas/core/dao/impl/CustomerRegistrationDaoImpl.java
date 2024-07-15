/**
 * CompanyDaoImpl.java
 * @copyright��Copyright � 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.CustomerRegistrationDaoCustomMethods;
import co.ipicorp.saas.core.model.CustomerRegistration;
import grass.micro.apps.model.dto.SearchCondition;

/**
 * CustomerRegistrationDaoImpl. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Repository
@Transactional
public class CustomerRegistrationDaoImpl implements CustomerRegistrationDaoCustomMethods {
	@Autowired
	@Qualifier("authEntityManager")
	private EntityManager entityManager;

	@Override
	public List<CustomerRegistration> search(SearchCondition search) {
		// TODO Auto-generated method stub
		return null;
	}

}
