/**
 * CustomerType.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

/**
 * RoleType. INDIVIDUAL, ENTERPRISE: Company will be required with this customer type.
 * 
 * @author hieumicro
 * @access public
 */
public enum CustomerType {
    INDIVIDUAL(0), ENTERPRISE(1);

    private int value;

    /**
     * @param value
     */
    private CustomerType(int value) {
        this.value = value;
    }

    public static CustomerType fromValue(int value) {
        CustomerType type = INDIVIDUAL;
        switch (value) {
            case 0:
                type = INDIVIDUAL;
                break;
            case 1:
                type = ENTERPRISE;
                break;
            default:
                break;
        }
        return type;
    }

    /**
     * get value of <b>value</b>.
     * 
     * @return the value
     */
    public int getValue() {
        return value;
    }

}
