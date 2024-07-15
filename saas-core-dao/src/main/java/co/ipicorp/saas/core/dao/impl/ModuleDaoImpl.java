/**
 * ModuleDaoImpl.java
 * @copyright��Copyright � 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.ModuleDaoCustomMethods;

/**
 * ModuleDaoImpl.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
@Repository
@Transactional
public class ModuleDaoImpl implements ModuleDaoCustomMethods {
    @Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;
}
