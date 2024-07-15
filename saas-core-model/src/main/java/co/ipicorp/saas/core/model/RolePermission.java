/**
 * RolePermission.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import grass.micro.apps.model.base.AbstractIdentifiedEntity;

/**
 * RolePermission. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "td_role_permission")
public class RolePermission extends AbstractIdentifiedEntity implements Serializable {

	private static final long serialVersionUID = 8352742410234357157L;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
	private Permission permission;

	/**
     * @return the role
     */
	public Role getRole() {
		return role;
	}

	/**
	 * @param name the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
     * @return the permission
     */
	public Permission getPermission() {
		return permission;
	}

	/**
	 * @param name the permission to set
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RolePermission [role=" + role + ", permission=" + permission + "]";
	}

}
