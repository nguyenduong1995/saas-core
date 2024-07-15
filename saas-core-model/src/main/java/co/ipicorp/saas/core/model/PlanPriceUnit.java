/**
 * PlanPriceUnit.java
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
 * PlanPriceUnit. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "td_plan_price_unit", uniqueConstraints = { @UniqueConstraint(columnNames = { "plan_id", "price_unit_id" }) })
public class PlanPriceUnit extends AbstractIdentifiedEntity implements Serializable {

	private static final long serialVersionUID = 8352742410234357157L;

	@Column(name = "plan_id", nullable = false, length = 11)
	private Integer planId;
	
	@Column(name = "price_unit_id", nullable = false, length = 11)
	private Integer priceUnitId;

	/**
     * @return the planId
     */
	public Integer getPlanId() {
		return planId;
	}

	/**
	 * @param name the planId to set
	 */
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	/**
     * @return the priceUnitId
     */
	public Integer getPriceUnitId() {
		return priceUnitId;
	}

	/**
	 * @param name the priceUnitId to set
	 */
	public void setPriceUnitId(Integer priceUnitId) {
		this.priceUnitId = priceUnitId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlanPriceUnit [planId=" + planId + ", priceUnitId=" + priceUnitId + "]";
	}

}
