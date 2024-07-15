package co.ipicorp.saas.core.dao.impl;

import co.ipicorp.saas.core.dao.StaffDaoCustomMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * 
 * StaffDaoImpl. <<< Detail note.
 * 
 * @author nguyeth
 * @access public
 */
@Repository
@Transactional
public class StaffDaoImpl implements StaffDaoCustomMethods {

    @Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;

    
}
