package co.ipicorp.saas.core.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.CustomerMetadataDaoCustomMethods;

/**
 * 
 * @author ntduong
 *
 */
@Repository
@Transactional
public class CustomerMetadataDaoImpl implements CustomerMetadataDaoCustomMethods {
	
	@Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;
	
}
