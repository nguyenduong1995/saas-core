/**
 * Module.java
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
 * Module. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "m_module")
public class Module extends StatusLockAuditableEntity {
	
	private static final long serialVersionUID = -5094111175795963719L;

	@Column(name = "module_name", nullable = false, length = 255)
    private String moduleName;

	@Column(name = "description", nullable = true, length = 2048)
    private String description;
	
    @Column(name = "module_group", nullable = true, length = 11)
    private Integer moduleGroup;
    
    @Column(name = "module_group_name", nullable = false, length = 128)
    private String moduleGroupName;
    
    @Column(name = "required_modules", nullable = false, length = 255)
    private String requiredModules;

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param name the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the moduleGroup
	 */
	public Integer getModuleGroup() {
		return moduleGroup;
	}

	/**
	 * @param name the moduleGroup to set
	 */
	public void setModuleGroup(Integer moduleGroup) {
		this.moduleGroup = moduleGroup;
	}
	
	/**
	 * @return the moduleGroupName
	 */
	public String getModuleGroupName() {
		return moduleGroupName;
	}

	/**
	 * @param name the moduleGroupName to set
	 */
	public void setModuleGroupName(String moduleGroupName) {
		this.moduleGroupName = moduleGroupName;
	}
	
	/**
	 * @return the requiredModule
	 */
	public String getRequiredModules() {
		return requiredModules;
	}

	/**
	 * @param name the requiredModule to set
	 */
	public void setRequiredModules(String requiredModules) {
		this.requiredModules = requiredModules;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Module [moduleName=" + moduleName + ", description=" + description + ", moduleGroup=" + moduleGroup
				 + ", moduleGroupName=" + moduleGroupName + ", requiredModules=" + requiredModules + "]";
	}

}
