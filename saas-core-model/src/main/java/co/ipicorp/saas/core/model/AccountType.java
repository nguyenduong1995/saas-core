/**
 * AccountType.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

/**
 * AccountType.
 * STAFF: for internal user
 * CUSTOMER: Account use for customer login to system.
 * 
 * @author hieumicro
 * @access public
 */
public enum AccountType {
    STAFF(0), CUSTOMER(1), STAFF_OF_CUSTOMER(2), RETAILER(3), STAFF_OF_RETAILER(4), SALEMAN(5);

    private int value;

    /**
     * @param value
     */
    private AccountType(int value) {
        this.value = value;
    }

    public static AccountType fromValue(int value) {
        AccountType type = STAFF;
        
        switch (value) {
            case 0:
                type = STAFF;
                break;
            case 1:
                type = CUSTOMER;
                break;
            case 2:
                type = STAFF_OF_CUSTOMER;
                break;
            case 3:
                type = RETAILER;
                break;
            case 4:
                type = STAFF_OF_RETAILER;
                break;
            case 5:
                type = SALEMAN;
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
