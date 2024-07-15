/**
 * ModuleService.java
 * @author     nt.duong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.Module;
import grass.micro.apps.service.GenericService;

/**
 * ModuleService.
 * <<< Service related to {@link ModuleService}.
 * @author nt.duong
 * @access public
 */
public interface ModuleService extends GenericService<Module, Integer> {
	
	List<Module> getAllAvailable();
}
