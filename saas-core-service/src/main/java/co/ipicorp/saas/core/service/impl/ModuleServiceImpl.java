/**
 * ModuleServiceImpl.java
 * @author     nt.duong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.ipicorp.saas.core.dao.ModuleDao;
import co.ipicorp.saas.core.model.Module;
import co.ipicorp.saas.core.service.ModuleService;
import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * ModuleServiceImpl.
 * <<< Implementation of {@link ModuleServiceImpl}.
 * @author nt.duong
 * @access public
 */
@Service
public class ModuleServiceImpl extends GenericServiceImpl<Module, Integer> implements ModuleService  {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(ModuleServiceImpl.class);

    @Autowired
    private ModuleDao moduleDao;

	@Override
	public CrudRepository<Module, Integer> getDao() {
		// TODO Auto-generated method stub
		return this.moduleDao;
	}

	@Override
	public List<Module> search(SearchCondition condition) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public List<Module> getAllAvailable() {
        try {
            return (List<Module>) this.moduleDao.findAllAvailable();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

}
