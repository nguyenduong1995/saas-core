/**
 * PriceUnitServiceImpl.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.PriceUnitDao;
import co.ipicorp.saas.core.model.PriceUnit;
import co.ipicorp.saas.core.service.PriceUnitService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * PriceUnitServiceImpl.
 * <<< Implementation of {@link PriceUnitService}.
 * @author ntduong
 * @access public
 */
@Service
public class PriceUnitServiceImpl extends GenericServiceImpl<PriceUnit, Integer> implements PriceUnitService  {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(PriceUnitServiceImpl.class);

    @Autowired
    private PriceUnitDao priceUnitDao;

    @Override
	public CrudRepository<PriceUnit, Integer> getDao() {
		// TODO Auto-generated method stub
		return this.priceUnitDao;
	}
    
	@Override
    public List<PriceUnit> getAll() {
        try {
            return (List<PriceUnit>) this.priceUnitDao.findAllActivated();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<PriceUnit> getAllAvailable() {
        try {
            return (List<PriceUnit>) this.priceUnitDao.findAllAvailable();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

	@Override
	public List<PriceUnit> search(SearchCondition condition) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceUnit getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
