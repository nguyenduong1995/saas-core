/**
 * RoleTypeConverter.java
 */

package co.ipicorp.saas.core.model.util;

import javax.persistence.AttributeConverter;

import co.ipicorp.saas.core.model.RoleType;

/**
 * RoleTypeConverter.
 */
public class RoleTypeConverter implements AttributeConverter<RoleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoleType type) {
        return type.getValue();
    }

    @Override
    public RoleType convertToEntityAttribute(Integer value) {
        return RoleType.fromValue(value);
    }

}
