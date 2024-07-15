/**
 * InvoiceServiceImpl.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.InvoiceDao;
import co.ipicorp.saas.core.model.Invoice;
import co.ipicorp.saas.core.service.InvoiceService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * InvoiceServiceImpl.
 * <<< Implementation of {@link InvoiceServiceImpl}.
 * @author ntduong
 * @access public
 */
@Service
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice, Integer> implements InvoiceService  {
    
    @SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(InvoiceServiceImpl.class);

    @Autowired
    private InvoiceDao invoiceDao;

    @Override
	public CrudRepository<Invoice, Integer> getDao() {
		// TODO Auto-generated method stub
		return this.invoiceDao;
	}
    
	@Override
    public List<Invoice> getAll() {
        try {
            return (List<Invoice>) this.invoiceDao.findAllActivated();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<Invoice> getAllAvailable() {
        try {
            return (List<Invoice>) this.invoiceDao.findAllAvailable();
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

	@Override
	public List<Invoice> search(SearchCondition condition) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
