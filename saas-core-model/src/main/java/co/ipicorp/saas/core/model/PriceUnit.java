/**
 * PriceUnit.java
 * @copyright  Copyright © 2020 Vndata
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;

/**
 * PriceUnit. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "m_price_unit")
public class PriceUnit extends StatusLockAuditableEntity {

	private static final long serialVersionUID = 5765144390436488909L;
	
	@Column(name = "`type`", nullable = false, length = 16)
    private String type;
	
	@Column(name = "yearly_price_per_unit", nullable = false, length = 11)
    private Integer yearlyPrice;

    @Column(name = "monthly_price_per_unit", nullable = false, length = 11)
    private Integer monthlyPrice;
    
    @Column(name = "quota_key", nullable = true, length = 128)
    private String quotaKey;
    
    @Column(name = "quota_unit_count", nullable = true, length = 11)
    private Integer quotaUnitCount;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;
    
    /**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param name the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
    
	/**
	 * @return the yearlyPrice
	 */
	public Integer getYearlyPrice() {
		return yearlyPrice;
	}

	/**
	 * @param name the yearlyPrice to set
	 */
	public void setYearlyPrice(Integer yearlyPrice) {
		this.yearlyPrice = yearlyPrice;
	}
	
	/**
	 * @return the monthlyPrice
	 */
	public Integer getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * @param name the monthlyPrice to set
	 */
	public void setMonthlyPrice(Integer monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}
	
	/**
	 * @return the quotaKey
	 */
	public String getQuotaKey() {
		return quotaKey;
	}

	/**
	 * @param name the quotaKey to set
	 */
	public void setQuotaKey(String quotaKey) {
		this.quotaKey = quotaKey;
	}

	/**
	 * @return the quotaUnitCount
	 */
	public Integer getQuotaUnitCount() {
		return quotaUnitCount;
	}

	/**
	 * @param name the quotaUnitCount to set
	 */
	public void setQuotaUnitCount(Integer quotaUnitCount) {
		this.quotaUnitCount = quotaUnitCount;
	}

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param name the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}
	
	@Override
    public String toString() {
        return "PriceUnit [type=" + type + ", yearlyPrice=" + yearlyPrice + ", monthlyPrice=" + monthlyPrice 
        		+ ", quotaKey=" + quotaKey + ", quotaUnitCount=" + quotaUnitCount + ", module=" + module + "]";
    }
	
}
