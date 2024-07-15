/**
 * RegionServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.RegionDao;
import co.ipicorp.saas.core.model.Region;
import co.ipicorp.saas.core.service.RegionService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * RegionServiceImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Service
public class RegionServiceImpl extends GenericServiceImpl<Region, Integer> implements RegionService {
    
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(RegionServiceImpl.class);

    @Autowired
    private RegionDao regionDao;

    @Override
    public CrudRepository<Region, Integer> getDao() {
        return this.regionDao;
    }

    @Override
    public List<Region> search(SearchCondition condition) throws ServiceException {
        return null;
    }
    
}    
