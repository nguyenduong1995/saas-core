/**
 * CityDaoImpl.java
 * @copyright��Copyright � 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import co.ipicorp.saas.core.dao.CityDaoCustomMethods;

/**
 * CityDaoImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Repository
@Transactional
public class CityDaoImpl implements CityDaoCustomMethods {
    
    @Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;
}
