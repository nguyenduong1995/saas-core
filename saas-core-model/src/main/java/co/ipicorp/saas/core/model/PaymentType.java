/**
 * PaymentType.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

/**
 * 
 * @author ntduong
 * @access public
 */
public enum PaymentType {
	MONTHLY(0), YEARLY(1);

    private int value;

    /**
     * @param value
     */
    private PaymentType(int value) {
        this.value = value;
    }

    public static PaymentType fromValue(int value) {
    	PaymentType type = MONTHLY;
        switch (value) {
            case 0:
                type = MONTHLY;
                break;
            case 1:
                type = YEARLY;
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
