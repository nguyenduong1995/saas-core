/**
 * CustomerMetakeyType.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

/**
 * CustomerMetakeyType.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public enum CustomerMetakeyType {
    PLAIN_TEXT(0), JSON(1), JWT(2); 
    
    private int value = 0;
    
    private CustomerMetakeyType(int value) {
        this.value = value;
    }

    /**
     * get value of <b>value</b>.
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Set value to <b>value</b>.
     * @param value the value to set
     */
    public static CustomerMetakeyType fromValue(int value) {
        CustomerMetakeyType result = PLAIN_TEXT;
        switch (value) {
            case 1:
                result = JSON;
                break;
            case 2:
                result = JWT;
                break;
            default:
                break;
        }
        
        return result;
    }
    
    
}
