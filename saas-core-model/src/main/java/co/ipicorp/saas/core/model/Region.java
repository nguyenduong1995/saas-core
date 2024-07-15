/**
 * Region.java
 * @copyright  Copyright © 2020 Vndata
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
 * Region. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "m_region")
public class Region extends AbstractIdentifiedEntity implements Serializable {
	
	private static final long serialVersionUID = -2192784489122580817L;
	
	@Column(name = "name", nullable = false, length = 255)
    private String name;

	@Column(name = "macro_region_code", nullable = false, length = 11)
    private Integer macroRegionCode;
	
	@Column(name = "macro_region_name", nullable = false, length = 255)
    private String macroRegionName;
	
	/** Constructor . */
    public Region() {
    }
    
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
	 * @return the macroRegionCode
	 */
	public Integer getMacroRegionCode() {
		return macroRegionCode;
	}

	/**
	 * @param name the macroRegionCode to set
	 */
	public void setMacroRegionCode(Integer macroRegionCode) {
		this.macroRegionCode = macroRegionCode;
	}
	
	/**
     * get value of <b>macroRegionName</b>.
     * @return the macroRegionName
     */
    public String getMacroRegionName() {
        return macroRegionName;
    }

    /**
     * Set value to <b>macroRegionName</b>.
     * @param macroRegionName the macroRegionName to set
     */
    public void setMacroRegionName(String macroRegionName) {
        this.macroRegionName = macroRegionName;
    }

    @Override
    public String toString() {
        return "Region [name=" + name + ", macroRegionCode=" + macroRegionCode + ", macroRegionName=" + macroRegionName + "]";
    }
	
}
