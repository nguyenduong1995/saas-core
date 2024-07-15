/**
 * UserService.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.User;
import grass.micro.apps.service.GenericService;

/**
 * UserService.
 * <<< Service related to {@link User}.
 * @author hieumicro
 * @access public
 */
public interface UserService extends GenericService<User, Integer> {

    
    /**
     * Get {@link User} by given id.
     * @param id given id.
     * @return {@link User} instance.
     */
    User getById(int id);
    
    /**
     * Get all {@link User}.
     * @return {@link List} of {@link User} instance.
     */
    List<User> getAll();
    
    /**
     * Get all available {@link User} (VALID and DRAFT status).
     * @return {@link List} of {@link User} instance.
     */
    List<User> getAllAvailable();

    /**
     * Get an {@link User} by given account id.
     * @return {@link List} of {@link User} instance.
     */
    User getByAccountId(int id);
}
