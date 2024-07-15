/**
 * PlanServiceImpl.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.ipicorp.saas.core.dao.PlanDao;
import co.ipicorp.saas.core.model.Plan;
import co.ipicorp.saas.core.model.PriceUnit;
import co.ipicorp.saas.core.service.PlanService;
import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * PlanServiceImpl.
 * <<< Implementation of {@link PlanServiceImpl}.
 * @author ntduong
 * @access public
 */
@Service
public class PlanServiceImpl extends GenericServiceImpl<Plan, Integer> implements PlanService  {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(PlanServiceImpl.class);

    @Autowired
    private PlanDao planDao;

    @Override
	public CrudRepository<Plan, Integer> getDao() {
		// TODO Auto-generated method stub
		return this.planDao;
	}
    
	@Override
    public List<Plan> getAll() {
        try {
            return (List<Plan>) this.planDao.findAllActivated();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<Plan> getAllAvailable() {
        try {
            return (List<Plan>) this.planDao.findAllAvailable();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

	@Override
	public List<Plan> search(SearchCondition condition) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceUnit getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> getAllPlanAndCountCustomer() {
		try {
			return this.planDao.findAllPlanAndCountCustomer();
		} catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}
	
}
