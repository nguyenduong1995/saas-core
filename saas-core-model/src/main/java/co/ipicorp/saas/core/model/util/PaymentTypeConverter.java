/**
 * PaymentTypeConverter.java
 */

package co.ipicorp.saas.core.model.util;

import javax.persistence.AttributeConverter;

import co.ipicorp.saas.core.model.PaymentType;

/**
 * PaymentTypeConverter.
 */
public class PaymentTypeConverter implements AttributeConverter<PaymentType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PaymentType type) {
        return type.getValue();
    }

    @Override
    public PaymentType convertToEntityAttribute(Integer value) {
        return PaymentType.fromValue(value);
    }

}
