/**
 * DistrictServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.DistrictDao;
import co.ipicorp.saas.core.model.District;
import co.ipicorp.saas.core.service.DistrictService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * DistrictServiceImpl.
 * <<< Detail note.
 * @author ntduong
 * @access public
 */
@Service
public class DistrictServiceImpl extends GenericServiceImpl<District, Integer> implements DistrictService {
    
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(DistrictServiceImpl.class);

    @Autowired
    private DistrictDao districtDao;

    @Override
    public CrudRepository<District, Integer> getDao() {
        return this.districtDao;
    }

    @Override
    public List<District> search(SearchCondition condition) throws ServiceException {
        return null;
    }

	@Override
	public List<District> getAllByCityCode(String cityCode) {
		return this.districtDao.findByCityCode(cityCode);
	}

    @Override
    public List<District> getByCityId(int cityId) {
        return this.districtDao.findByCityId(cityId);
    }
    
}    
