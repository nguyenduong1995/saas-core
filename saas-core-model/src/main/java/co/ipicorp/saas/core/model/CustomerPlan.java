/**
 * CustomerPlan.java
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.ipicorp.saas.core.model.util.PaymentTypeConverter;
import grass.micro.apps.model.base.StatusLockAuditableEntity;
import grass.micro.apps.model.util.LocalDateTimeAttributeConverter;

/**
 * CustomerPlan. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "td_customer_plan", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "is_trial", "start_date" }) })
public class CustomerPlan extends StatusLockAuditableEntity {

	private static final long serialVersionUID = 4312508826797591721L;
	
	@Column(name = "customer_id", nullable = false, length = 11)
    private Integer customerId;
	
	@Column(name = "plan_id", nullable = false, length = 11)
    private Integer planId;
	
	@Column(name = "is_trial", nullable = false, length = 11)
    private Integer isTrial;
	
	@Column(name = "payment_type")
	@Convert(converter = PaymentTypeConverter.class)
    private PaymentType paymentType = PaymentType.MONTHLY;
	
	@Column(name = "start_date", nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime startDate;
	
	@Column(name = "end_date", nullable = true)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime endDate;

	@Column(name = "auto_renew", nullable = false, length = 1)
    private Integer autoRenew;

	/**
     * @return the customerId
     */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param name the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

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
     * @return the isTrial
     */
	public Integer getIsTrial() {
		return isTrial;
	}

	/**
	 * @param name the isTrial to set
	 */
	public void setIsTrial(Integer isTrial) {
		this.isTrial = isTrial;
	}

	/**
     * @return the paymentType
     */
	public PaymentType getPaymentType() {
		return paymentType;
	}

	/**
	 * @param name the paymentType to set
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	/**
     * @return the startDate
     */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param name the startDate to set
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
     * @return the endDate
     */
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * @param name the endDate to set
	 */
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	/**
     * @return the autoRenew
     */
	public Integer getAutoRenew() {
		return autoRenew;
	}

	/**
	 * @param name the autoRenew to set
	 */
	public void setAutoRenew(Integer autoRenew) {
		this.autoRenew = autoRenew;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerPlan [customerId=" + customerId + ", planId=" + planId + ", isTrial=" + isTrial 
				+ ", paymentType=" + paymentType + ", startDate=" + startDate + ", endDate=" + endDate 
				+ ", autoRenew=" + autoRenew + "]";
	}
	
}
