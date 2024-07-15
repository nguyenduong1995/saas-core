/**
 * AccountTwoFactorServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.AccountTwoFactorDao;
import co.ipicorp.saas.core.model.AccountTwoFactor;
import co.ipicorp.saas.core.model.TwoFactorType;
import co.ipicorp.saas.core.service.AccountTwoFactorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * AccountTwoFactorServiceImpl. <<< Detail note.
 * 
 * @author hieumicro
 * @access public
 */
@Service
public class AccountTwoFactorServiceImpl extends GenericServiceImpl<AccountTwoFactor, Integer>
        implements AccountTwoFactorService {
    @Autowired
    private AccountTwoFactorDao accountTwoFactorDao;

    @Override
    public CrudRepository<AccountTwoFactor, Integer> getDao() {
        return this.accountTwoFactorDao;
    }

    @Override
    public List<AccountTwoFactor> search(SearchCondition condition) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AccountTwoFactor getByAccountIdAndTwoFactorType(int accountId, TwoFactorType type) {
        return this.accountTwoFactorDao.findByAccountIdAndTwoFactorType(accountId, type);
    }

}
