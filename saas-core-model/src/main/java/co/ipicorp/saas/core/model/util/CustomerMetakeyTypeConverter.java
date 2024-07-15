package co.ipicorp.saas.core.model.util;

import co.ipicorp.saas.core.model.CustomerMetakeyType;
import co.ipicorp.saas.core.model.CustomerType;

import javax.persistence.AttributeConverter;

public class CustomerMetakeyTypeConverter implements AttributeConverter<CustomerMetakeyType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CustomerMetakeyType type) {
        return type.getValue();
    }

    @Override
    public CustomerMetakeyType convertToEntityAttribute(Integer value) {
        return CustomerMetakeyType.fromValue(value.intValue());
    }
}