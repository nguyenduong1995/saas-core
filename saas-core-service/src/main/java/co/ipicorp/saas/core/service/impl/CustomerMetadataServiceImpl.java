/**
 * CustomerServiceImpl.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.ipicorp.saas.core.dao.CustomerMetadataDao;
import co.ipicorp.saas.core.model.CustomerMetadata;
import co.ipicorp.saas.core.model.CustomerMetakeyType;
import co.ipicorp.saas.core.service.CustomerMetadataService;
import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * CustomerMetadataServiceImpl.
 * <<< Implementation of {@link CustomerMetadataService}.
 * @author ntduong
 * @access public
 */
@Service
public class CustomerMetadataServiceImpl extends GenericServiceImpl<CustomerMetadata, Integer> implements CustomerMetadataService {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(CustomerMetadataServiceImpl.class);

    @Autowired
    private CustomerMetadataDao customerMetadataDao;

	@Override
	public CrudRepository<CustomerMetadata, Integer> getDao() {
		return this.customerMetadataDao;
	}

	@Override
	public List<CustomerMetadata> getByCustomerId(int id) {
		return this.customerMetadataDao.findAllByCustomerId(id);
	}

	@Override
	public List<CustomerMetadata> search(SearchCondition condition) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CustomerMetadata> saveAll(List<CustomerMetadata> customerMetadatas) {
		return this.customerMetadataDao.saveAll(customerMetadatas);
	}
	
	@Override
	public CustomerMetadata getByTextKeyValue(String key, String value) {
	    return this.customerMetadataDao.findByTextKeyValue(CustomerMetakeyType.PLAIN_TEXT, key, value);
	}

    @Override
    public CustomerMetadata getByCustomerIdAndKey(int customerId, String key) {
        return this.customerMetadataDao.findByCustomerIdAndKey(customerId, key);
    }
}
