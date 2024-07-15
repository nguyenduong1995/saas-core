/**
 * RoleSearchCondition.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model.dto;

import java.io.Serializable;

import grass.micro.apps.model.base.Status;
import grass.micro.apps.model.dto.TimestampSearchCondition;

/**
 * RoleSearchCondition.
 * <<< Detail note.
 * @author haitva
 * @access public
 */
public class RoleSearchCondition extends TimestampSearchCondition implements Serializable{
    private static final long serialVersionUID = 7623662926902179718L;
    private boolean enableRoleName;
    private String roleName;
    private boolean enableStatus;
    private Status status;
    /**
     * get value of <b>enableRoleName</b>.
     * @return the enableRoleName
     */
    public boolean isEnableRoleName() {
        return enableRoleName;
    }
    /**
     * Set value to <b>enableRoleName</b>.
     * @param enableRoleName the enableRoleName to set
     */
    public void setEnableRoleName(boolean enableRoleName) {
        this.enableRoleName = enableRoleName;
    }
    /**
     * get value of <b>roleName</b>.
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
    /**
     * Set value to <b>roleName</b>.
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    /**
     * get value of <b>enableStatus</b>.
     * @return the enableStatus
     */
    public boolean isEnableStatus() {
        return enableStatus;
    }
    /**
     * Set value to <b>enableStatus</b>.
     * @param enableStatus the enableStatus to set
     */
    public void setEnableStatus(boolean enableStatus) {
        this.enableStatus = enableStatus;
    }
    /**
     * get value of <b>status</b>.
     * @return the status
     */
    public Status getStatus() {
        return status;
    }
    /**
     * Set value to <b>status</b>.
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "RoleSearchCondition [enableRoleName=" + enableRoleName + ", roleName=" + roleName + ", enableStatus="
                + enableStatus + ", staus=" + status + "]";
    }
}
