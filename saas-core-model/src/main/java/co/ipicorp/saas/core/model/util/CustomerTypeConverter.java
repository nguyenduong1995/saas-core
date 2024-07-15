/**
 * AccountTypeConverter.java
 */

package co.ipicorp.saas.core.model.util;

import javax.persistence.AttributeConverter;

import co.ipicorp.saas.core.model.CustomerType;

/**
 * AccountTypeConverter.
 */
public class CustomerTypeConverter implements AttributeConverter<CustomerType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CustomerType type) {
        return type.getValue();
    }

    @Override
    public CustomerType convertToEntityAttribute(Integer value) {
        return CustomerType.fromValue(value);
    }

}
