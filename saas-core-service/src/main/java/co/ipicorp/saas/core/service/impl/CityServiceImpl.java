/**
 * CityServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.CityDao;
import co.ipicorp.saas.core.model.City;
import co.ipicorp.saas.core.service.CityService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * CityServiceImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Service
public class CityServiceImpl extends GenericServiceImpl<City, Integer> implements CityService {
    
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;

    @Override
    public CrudRepository<City, Integer> getDao() {
        return this.cityDao;
    }

    @Override
    public List<City> search(SearchCondition condition) throws ServiceException {
        return null;
    }

    @Override
    public City getByCode(String code) {
        return this.cityDao.findByCode(code);
    }

    @Override
    public List<City> getByRegionId(int regionId) {
        return this.cityDao.findByRegionId(regionId);
    }
    
}    
