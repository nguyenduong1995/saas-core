/**
 * WardServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.WardDao;
import co.ipicorp.saas.core.model.Ward;
import co.ipicorp.saas.core.service.WardService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * WardServiceImpl.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
@Service
public class WardServiceImpl extends GenericServiceImpl<Ward, Integer> implements WardService {
    
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(WardServiceImpl.class);

    @Autowired
    private WardDao wardDao;

    @Override
    public CrudRepository<Ward, Integer> getDao() {
        return this.wardDao;
    }

    @Override
    public List<Ward> search(SearchCondition condition) throws ServiceException {
        return null;
    }

	@Override
	public List<Ward> getByDistrictCode(String districtCode) {
		return this.wardDao.findByDistrictCode(districtCode);
	}

    @Override
    public List<Ward> getByDistrictId(Integer districtId) {
        return this.wardDao.findByDistrictId(districtId);
    }
    
}    
