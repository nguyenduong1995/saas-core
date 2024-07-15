/**
 * StaffService.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.Staff;
import grass.micro.apps.service.GenericService;

/**
 * StaffService.
 * <<< Service related to {@link Staff}.
 * @author nguyeth
 * @access public
 */
public interface StaffService extends GenericService<Staff, Integer> {

    
    /**
     * Get {@link Staff} by given id.
     * @param id given id.
     * @return {@link Staff} instance.
     */
    Staff getById(int id);
    
    /**
     * Get all {@link Staff}.
     * @return {@link List} of {@link Staff} instance.
     */
    List<Staff> getAll();
    
    /**
     * Get all available {@link Staff} (VALID and DRAFT status).
     * @return {@link List} of {@link Staff} instance.
     */
    List<Staff> getAllAvailable();

    /**
     * Get an {@link Staff} by given account id.
     * @return {@link List} of {@link Staff} instance.
     */
    Staff getByAccountId(int id);
}
