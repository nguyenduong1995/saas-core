/**
 * CustomerRolePermission.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.AbstractIdentifiedEntity;

/**
 * CustomerRolePermission. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "td_customer_role_permission")
public class CustomerRolePermission extends AbstractIdentifiedEntity implements Serializable {

	private static final long serialVersionUID = 8178219619673622586L;
	
	@Column(name = "customer_role_id", nullable = false, length = 11)
	private Integer custRoleId;
	
	@Column(name = "customer_permission_id", nullable = false, length = 11)
	private Integer custPermissionId;

	/**
     * @return the custRoleId
     */
	public Integer getCustRoleId() {
		return custRoleId;
	}

	/**
	 * @param name the custRoleId to set
	 */
	public void setCustRoleId(Integer custRoleId) {
		this.custRoleId = custRoleId;
	}

	/**
     * @return the custPermissionId
     */
	public Integer getCustPermissionId() {
		return custPermissionId;
	}

	/**
	 * @param name the custPermissionId to set
	 */
	public void setCustPermissionId(Integer custPermissionId) {
		this.custPermissionId = custPermissionId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerRolePermission [custRoleId=" + custRoleId + ", custPermissionId=" + custPermissionId + "]";
	}

}
