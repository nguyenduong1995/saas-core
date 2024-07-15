/**
 * CompanyServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.CompanyDao;
import co.ipicorp.saas.core.model.Company;
import co.ipicorp.saas.core.service.CompanyService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * CompanyServiceImpl.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
@Service
public class CompanyServiceImpl extends GenericServiceImpl<Company, Integer> implements CompanyService {
    
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyDao companyDao;

    @Override
    public CrudRepository<Company, Integer> getDao() {
        return this.companyDao;
    }

    @Override
    public List<Company> search(SearchCondition condition) throws ServiceException {
        return null;
    }

	@Override
	public Company getByFullname(String fullname) {
		try {
            return this.companyDao.getByFullname(fullname);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
	}
    
}    
