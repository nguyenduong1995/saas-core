/**
 * AccountTypeConverter.java
 */

package co.ipicorp.saas.core.model.util;

import javax.persistence.AttributeConverter;

import co.ipicorp.saas.core.model.AccountType;

/**
 * AccountTypeConverter.
 */
public class TwoFactorTypeConverter implements AttributeConverter<AccountType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AccountType type) {
        return type.getValue();
    }

    @Override
    public AccountType convertToEntityAttribute(Integer value) {
        return AccountType.fromValue(value);
    }

}
