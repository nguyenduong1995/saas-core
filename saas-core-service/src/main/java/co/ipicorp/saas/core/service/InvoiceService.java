/**
 * InvoiceService.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.Invoice;
import grass.micro.apps.service.GenericService;

/**
 * InvoiceService.
 * <<< Service related to {@link InvoiceService}.
 * @author ntduong
 * @access public
 */
public interface InvoiceService extends GenericService<Invoice, Integer> {

    /**
     * Get {@link Invoice} by given id.
     * @param id given id.
     * @return {@link Invoice} instance.
     */
	Invoice getById(int id);
    
    /**
     * Get all {@link Invoice}.
     * @return {@link List} of {@link Invoice} instance.
     */
    List<Invoice> getAll();
    
    /**
     * Get all available {@link Invoice} (VALID and DRAFT status).
     * @return {@link List} of {@link Invoice} instance.
     */
    List<Invoice> getAllAvailable();


}
