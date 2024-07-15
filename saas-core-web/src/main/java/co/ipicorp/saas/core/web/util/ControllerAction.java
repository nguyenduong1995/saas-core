/**
 * ControllerAction.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.util;

/**
 * ControllerAction.
 * <<< Detail note.
 * @author hieumicro
 * @access public
 */
public class ControllerAction {
    /*
     * COMMON ACTION
     */
    public static final String APP_COMPANY_ACTION = "/companies";
    public static final String APP_COMPANY_DETAIL_ACTION = "/companies/{id}";
    public static final String APP_COMPANY_DETAIL_DEPARTMENT_ACTION = "/companies/{id}/departments";
    
    public static final String APP_DEPARTMENT_ACTION = "/departments";
    public static final String APP_DEPARTMENT_DETAIL_ACTION = "/departments/{id}";
    
    public static final String APP_REGION_ACTION = "/regions";
    public static final String APP_REGION_DETAIL_ACTION = "/regions/{id}";
    
    public static final String APP_CITY_ACTION = "/cities";
    public static final String APP_CITY_DETAIL_ACTION = "/cities/{id}";
    
    public static final String APP_DISTRICT_ACTION = "/districts";
    public static final String APP_DISTRICT_DETAIL_ACTION = "/districts/{id}";
    
    public static final String APP_WARD_ACTION = "/wards";
    public static final String APP_WARD_DETAIL_ACTION = "/wards/{id}";
    
    /*
     * Industry action
     */
    public static final String APP_PORTAL_INDUSTRY_ACTION = "/industries";
    public static final String APP_PORTAL_INDUSTRY_DETAIL_ACTION = "/industries/{id}";
}
