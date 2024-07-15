/**
 * CustomerRole.java
 * @copyright  Copyright © 2020 Vndata
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;

/**
 * CustomerRole. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "t_customer_role")
public class CustomerRole extends StatusLockAuditableEntity {

	private static final long serialVersionUID = -7140935578788113715L;
	
	@Column(name = "role_name", nullable = false, length = 256)
    private String roleName;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "role_type", nullable = false, length = 10)
    private Integer roleType;

    /**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param name the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param name the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the roleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * @param name the roleType to set
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	@Override
    public String toString() {
        return "CustomerRole [roleName=" + roleName + ", description=" + description + ", roleType=" + roleType + "]";
    }
    
}
