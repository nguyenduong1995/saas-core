/**
 * PermissionConstants.java
 */

package co.ipicorp.saas.core.model.util;

/**
 * PermissionConstants.
 * Define all available persistence on system.
 */
public class CommonPermissionConstants {
    /**
     * GROUP of STAFF
     */
    public static final String STAFF_VIEW = "staff_view";
    public static final String STAFF_CREATE = "staff_create";
    public static final String STAFF_EDIT = "staff_edit";
    public static final String STAFF_DELETE = "staff_edit";
    
    /**
     * GROUP of ROLE
     */
    public static final String ROLE_VIEW = "role_view";
    public static final String ROLE_CREATE = "role_create";
    public static final String ROLE_EDIT = "role_edit";
    public static final String ROLE_DELETE = "role_delete";
    
    /**
     * GROUP of CUSTOMER
     */
    public static final String CUSTOMER_VIEW = "customer_view";
    public static final String CUSTOMER_CREATE = "customer_create";
    public static final String CUSTOMER_EDIT = "customer_edit";
    public static final String CUSTOMER_DELETE = "customer_delete";
    
    /**
     * GROUP of CUSTOMER REGISTRATON
     */
    public static final String CUSTOMER_REGISTER_VIEW = "customer_register_view";
    public static final String CUSTOMER_REGISTER_CREATE = "customer_register_create";
    public static final String CUSTOMER_REGISTER_ACCEPT = "customer_register_accept";
    public static final String CUSTOMER_REGISTER_REJECT = "customer_register_reject";
}
