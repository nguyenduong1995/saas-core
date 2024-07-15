/**
 * UserRole.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import grass.micro.apps.model.base.AbstractIdentifiedEntity;

/**
 * UserRole. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "td_staff_role", uniqueConstraints = { @UniqueConstraint(columnNames = { "staff_id", "role_id" }) })
public class UserRole extends AbstractIdentifiedEntity implements Serializable {

	private static final long serialVersionUID = 8456563298523656546L;

	@Column(name = "staff_id", nullable = false, length = 11)
	private Integer staffId;
	
	@Column(name = "role_id", nullable = false, length = 11)
	private Integer roleId;

	/**
     * @return the staffId
     */
	public Integer getStaffId() {
		return staffId;
	}

	/**
	 * @param name the staffId to set
	 */
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	/**
     * @return the roleId
     */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param name the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRole [staffId=" + staffId + ", roleId=" + roleId + "]";
	}

}
