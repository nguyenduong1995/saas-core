/**
 * UserSearchCondition.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     hieumicro
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model.dto;

import java.io.Serializable;
import grass.micro.apps.model.base.Status;

import grass.micro.apps.model.dto.TimestampSearchCondition;

/**
 * UserSearchCondition. <<< Detail note.
 * 
 * @author haitva
 * @access public
 */
public class UserSearchCondition extends TimestampSearchCondition implements Serializable {
    private static final long serialVersionUID = 7611662926902179718L;
    private boolean enableLoginName;
    private String loginName;
    private boolean enableComanyId;
    private Integer companyId;
    private boolean enableDepartmentId;
    private Integer departmentId;
    private boolean enableFullName;
    private String fullName;
    private boolean enableMobile;
    private String mobile;
    private boolean enableEmail;
    private String email;
    private boolean enableRoleId;
    private Integer roleId;
    private boolean enableStatus;
    private Status status;
    
    /**
     * get value of <b>enableLoginName</b>.
     * @return the enableLoginName
     */
    public boolean isEnableLoginName() {
        return enableLoginName;
    }

    /**
     * Set value to <b>enableLoginName</b>.
     * @param enableLoginName the enableLoginName to set
     */
    public void setEnableLoginName(boolean enableLoginName) {
        this.enableLoginName = enableLoginName;
    }

    /**
     * get value of <b>loginName</b>.
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Set value to <b>loginName</b>.
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * get value of <b>enableComanyId</b>.
     * @return the enableComanyId
     */
    public boolean isEnableComanyId() {
        return enableComanyId;
    }

    /**
     * Set value to <b>enableComanyId</b>.
     * @param enableComanyId the enableComanyId to set
     */
    public void setEnableComanyId(boolean enableComanyId) {
        this.enableComanyId = enableComanyId;
    }

    /**
     * get value of <b>companyId</b>.
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * Set value to <b>companyId</b>.
     * @param companyId the companyId to set
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * get value of <b>enableDepartmentId</b>.
     * @return the enableDepartmentId
     */
    public boolean isEnableDepartmentId() {
        return enableDepartmentId;
    }

    /**
     * Set value to <b>enableDepartmentId</b>.
     * @param enableDepartmentId the enableDepartmentId to set
     */
    public void setEnableDepartmentId(boolean enableDepartmentId) {
        this.enableDepartmentId = enableDepartmentId;
    }

    /**
     * get value of <b>departmentId</b>.
     * @return the departmentId
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Set value to <b>departmentId</b>.
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * get value of <b>enableFullName</b>.
     * @return the enableFullName
     */
    public boolean isEnableFullName() {
        return enableFullName;
    }

    /**
     * Set value to <b>enableFullName</b>.
     * @param enableFullName the enableFullName to set
     */
    public void setEnableFullName(boolean enableFullName) {
        this.enableFullName = enableFullName;
    }

    /**
     * get value of <b>fullName</b>.
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set value to <b>fullName</b>.
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * get value of <b>enableMobile</b>.
     * @return the enableMobile
     */
    public boolean isEnableMobile() {
        return enableMobile;
    }

    /**
     * Set value to <b>enableMobile</b>.
     * @param enableMobile the enableMobile to set
     */
    public void setEnableMobile(boolean enableMobile) {
        this.enableMobile = enableMobile;
    }

    /**
     * get value of <b>mobile</b>.
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set value to <b>mobile</b>.
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * get value of <b>enableEmail</b>.
     * @return the enableEmail
     */
    public boolean isEnableEmail() {
        return enableEmail;
    }

    /**
     * Set value to <b>enableEmail</b>.
     * @param enableEmail the enableEmail to set
     */
    public void setEnableEmail(boolean enableEmail) {
        this.enableEmail = enableEmail;
    }

    /**
     * get value of <b>email</b>.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to <b>email</b>.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get value of <b>enableRoleId</b>.
     * @return the enableRoleId
     */
    public boolean isEnableRoleId() {
        return enableRoleId;
    }

    /**
     * Set value to <b>enableRoleId</b>.
     * @param enableRoleId the enableRoleId to set
     */
    public void setEnableRoleId(boolean enableRoleId) {
        this.enableRoleId = enableRoleId;
    }

    /**
     * get value of <b>roleId</b>.
     * @return the roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Set value to <b>roleId</b>.
     * @param roleId the roleId to set
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        return "UserSearchCondition [enableLoginName=" + enableLoginName + ", loginName=" + loginName
                + ", enableComanyId=" + enableComanyId + ", companyId=" + companyId + ", enableDepartmentId="
                + enableDepartmentId + ", departmentId=" + departmentId + ", enableFullName=" + enableFullName
                + ", fullName=" + fullName + ", enableMobile=" + enableMobile + ", mobile=" + mobile + ", enableEmail="
                + enableEmail + ", email=" + email + ", enableRoles=" + enableRoleId + ", roles=" + roleId
                + ", enableStatus=" + enableStatus + ", status=" + status + "]";
    }

}
