package co.ipicorp.saas.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;

/**
 * Industry. <<< Detail note.
 * 
 * @author Industry
 * @access public
 */
/**
 * @author User
 *
 */
@Entity
@Table(name = "m_industry")
public class Industry extends StatusLockAuditableEntity {

	private static final long serialVersionUID = -2610444859568620326L;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "industry_code", nullable = false, length = 16)
    private String industryCode;
    
    @Column(name = "level", nullable = false, length = 10)
    private Integer level;
    
    @Column(name = "description", nullable = true, length = 2048)
    private String description;
    
    @Column(name = "level1_code", nullable = false, length = 4)
    private String level1Code;
    
    @Column(name = "level2_code", nullable = true, length = 4)
    private String level2Code;
    
    @Column(name = "level3_code", nullable = true, length = 4)
    private String level3Code;
    
    @Column(name = "level4_code", nullable = true, length = 4)
    private String level4Code;
    
    @Column(name = "level5_code", nullable = true, length = 4)
    private String level5Code;

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
	 * @return the industryCode
	 */
	public String getIndustryCode() {
		return industryCode;
	}

	/**
	 * @param name the industryCode to set
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param name the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
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
	 * @return the level1Code
	 */
	public String getLevel1Code() {
		return level1Code;
	}

	/**
	 * @param name the level1Code to set
	 */
	public void setLevel1Code(String level1Code) {
		this.level1Code = level1Code;
	}
	
	/**
	 * @return the level2Code
	 */
	public String getLevel2Code() {
		return level1Code;
	}

	/**
	 * @param name the level1Code to set
	 */
	public void setLevel2Code(String level2Code) {
		this.level2Code = level2Code;
	}
	
	/**
	 * @return the level3Code
	 */
	public String getLevel3Code() {
		return level3Code;
	}

	/**
	 * @param name the level3Code to set
	 */
	public void setLevel3Code(String level3Code) {
		this.level3Code = level3Code;
	}
	
	/**
	 * @return the level4Code
	 */
	public String getLevel4Code() {
		return level4Code;
	}

	/**
	 * @param name the level4Code to set
	 */
	public void setLevel4Code(String level4Code) {
		this.level4Code = level4Code;
	}
	
	/**
	 * @return the level5Code
	 */
	public String getLevel5Code() {
		return level5Code;
	}

	/**
	 * @param name the level5Code to set
	 */
	public void setLevel5Code(String level5Code) {
		this.level5Code = level5Code;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Industry [name=" + name + ", industryCode=" + industryCode + ", level=" + level + ", description=" + description 
				+ ", level1Code=" + level1Code + ", level2Code=" + level2Code + ", level3Code=" + level3Code 
				+ ", level4Code=" + level4Code + ", level5Code=" + level5Code + "]";
	}

}
