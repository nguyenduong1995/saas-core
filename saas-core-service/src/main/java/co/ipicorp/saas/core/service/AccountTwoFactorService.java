/**
 * AccountTwoFactorService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import co.ipicorp.saas.core.model.AccountTwoFactor;
import co.ipicorp.saas.core.model.TwoFactorType;
import grass.micro.apps.service.GenericService;

/**
 * AccountTwoFactorService.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public interface AccountTwoFactorService extends GenericService<AccountTwoFactor, Integer> {
    AccountTwoFactor getByAccountIdAndTwoFactorType(int accountId, TwoFactorType type);
}
