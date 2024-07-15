/**
 * RoleType.java
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

/**
 * RoleType. DEFAULT_ROLE: the role CANNOT DELETE, default assign to user when created, or user doesn't have any role
 * SYSTEM_ROLE: the role CANNOT DELETE. NORMAL_ROLE: the role can edit.
 * 
 * @author hieumicro
 * @access public
 */
public enum RoleType {
    NORMAL_ROLE(0), SYSTEM_ROLE(1), DEFAULT_ROLE(2);

    private int value;

    /**
     * @param value
     */
    private RoleType(int value) {
        this.value = value;
    }

    public static RoleType fromValue(int value) {
        RoleType type = NORMAL_ROLE;
        switch (value) {
            case 0:
                type = NORMAL_ROLE;
                break;
            case 1:
                type = SYSTEM_ROLE;
                break;
            case 2:
                type = DEFAULT_ROLE;
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
