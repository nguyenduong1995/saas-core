/**
 * Plan.java
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
 * Plan. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "t_plan")
public class Plan extends StatusLockAuditableEntity {

	private static final long serialVersionUID = -6396913013580275900L;
	
	@Column(name = "name", nullable = true, length = 255)
    private String name;
    
    @Column(name = "description", nullable = true)
    private String description;
	
    @Column(name = "is_customize", nullable = false, length = 1)
    private Integer isCustomize;
	
    @Column(name = "is_public", nullable = false, length = 1)
    private Integer isPublic;

    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the isCustomize
	 */
	public Integer getIsCustomize() {
		return isCustomize;
	}

	/**
	 * @param name the isCustomize to set
	 */
	public void setIsCustomize(Integer isCustomize) {
		this.isCustomize = isCustomize;
	}

	/**
	 * @return the isPublic
	 */
	public Integer getIsPublic() {
		return isPublic;
	}

	/**
	 * @param name the isPublic to set
	 */
	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Plan [name=" + name + ", description=" + description + ", isCustomize=" + isCustomize + ", isPublic=" + isPublic + "]";
	}
    
}
