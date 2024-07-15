/**
 * AccountTwoFactorDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import grass.micro.apps.dao.base.PersistentCrudRepository;
import co.ipicorp.saas.core.model.AccountTwoFactor;
import co.ipicorp.saas.core.model.TwoFactorType;

/**
 * AccountTwoFactorDao.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public interface AccountTwoFactorDao extends PersistentCrudRepository<AccountTwoFactor, Integer>, AccountTwoFactorDaoCustomMethods {
    @Override
    @Query("SELECT at FROM AccountTwoFactor at WHERE at.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<AccountTwoFactor> findAllActivated();
    
    @Override
    @Query("SELECT at FROM AccountTwoFactor at WHERE at.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<AccountTwoFactor> findAllAvailable();
    
    /**
     * find List of {@link AccountTwoFactor} by given account id and {@link TwoFactorType}.
     * @param accountId Account ID.
     * @param type {@link TwoFactorType}
     * @return {@link List} of {@link AccountTwoFactor}
     */
    @Query("SELECT a FROM AccountTwoFactor a WHERE a.accountId = :accountId AND a.twoFactorType = :type")
    AccountTwoFactor findByAccountIdAndTwoFactorType(@Param("accountId") int accountId, @Param("type") TwoFactorType type);
}
