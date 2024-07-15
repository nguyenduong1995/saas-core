/**
 * InvoiceDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;

import co.ipicorp.saas.core.model.Invoice;
import grass.micro.apps.dao.base.PersistentCrudRepository;

/**
 * InvoiceDao.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
public interface InvoiceDao extends PersistentCrudRepository<Invoice, Integer>, InvoiceDaoCustomMethods {
    @Override
    @Query("SELECT u FROM Invoice u WHERE u.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<Invoice> findAllActivated();
    
    @Override
    @Query("SELECT u FROM Invoice u WHERE u.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Invoice> findAllAvailable();
}
