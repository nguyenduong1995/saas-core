/**
 * IndustryServiceImpl.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.IndustryDao;
import co.ipicorp.saas.core.model.Industry;
import co.ipicorp.saas.core.service.IndustryService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import grass.micro.apps.model.base.Status;
import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * IndustryServiceImpl.
 * <<< Implementation of {@link IndustryService}.
 * @author ntduong
 * @access public
 */
@Service
public class IndustryServiceImpl extends GenericServiceImpl<Industry, Integer> implements IndustryService  {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(IndustryServiceImpl.class);

    @Autowired
    private IndustryDao industryDao;
    
    @Override
    public CrudRepository<Industry, Integer> getDao() {
        return this.industryDao;
    }
    
	@Override
	public List<Industry> search(SearchCondition condition) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Industry> getActivatedByLevel(int level) {
        return this.industryDao.findByLevelAndStatuses(level, Arrays.asList(Status.ACTIVE));
    }

}
