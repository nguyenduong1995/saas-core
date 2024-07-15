/**
 * Invoice.java
 * @copyright  Copyright © 2020 Vndata
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;
import grass.micro.apps.model.util.JsonToMapConverter;
import grass.micro.apps.model.util.LocalDateTimeAttributeConverter;

/**
 * Invoice. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "t_invoice")
public class Invoice extends StatusLockAuditableEntity {

	private static final long serialVersionUID = -1728417164149354176L;
	
	@Column(name = "issue_date", nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime issueDate;
	
	@Column(name = "paid_date", nullable = true)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime paidDate;
	
	@Column(name = "start_date", nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime startDate;
	
	@Column(name = "end_date", nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime endDate;
	
	@Column(name = "amount", nullable = false, length = 20)
	private Integer amount;
	
	@Column(name = "vat", nullable = false, length = 20)
	private Integer vat;
	
	@Column(name = "total", nullable = false, length = 20)
	private Integer total;
	
	@Column(name = "bill_items", nullable = false)
	@Convert(converter = JsonToMapConverter.class)
	private LinkedHashMap<String, Object> billItems;
	
	@Column(name = "customer_id", nullable = false, length = 11)
	private Integer customerId;
	
	@Column(name = "plan_id", nullable = false, length = 11)
	private Integer planId;
	
	@Column(name = "customer_plan_id", nullable = false, length = 11)
	private Integer customerPlanId;

	/**
	 * @return the issueDate
	 */
	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	/**
	 * @param name the issueDate to set
	 */
	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the paidDate
	 */
	public LocalDateTime getPaidDate() {
		return paidDate;
	}

	/**
	 * @param name the paidDate to set
	 */
	public void setPaidDate(LocalDateTime paidDate) {
		this.paidDate = paidDate;
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
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param name the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the vat
	 */
	public Integer getVat() {
		return vat;
	}

	/**
	 * @param name the vat to set
	 */
	public void setVat(Integer vat) {
		this.vat = vat;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param name the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the billItems
	 */
	public LinkedHashMap<String, Object> getBillItems() {
		return billItems;
	}

	/**
	 * @param name the billItems to set
	 */
	public void setBillItems(LinkedHashMap<String, Object> billItems) {
		this.billItems = billItems;
	}

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
	 * @return the customerPlanId
	 */
	public Integer getCustomerPlanId() {
		return customerPlanId;
	}

	/**
	 * @param name the customerPlanId to set
	 */
	public void setCustomerPlanId(Integer customerPlanId) {
		this.customerPlanId = customerPlanId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Invoice [issueDate=" + issueDate + ", paidDate=" + paidDate + ", startDate=" + startDate + ", endDate=" + endDate 
				+ ", amount=" + amount + ", vat=" + vat + ", total=" + total + ", billItems=" + billItems + ", customerId=" 
				+ customerId + ", planId=" + planId + ", customerPlanId=" + customerPlanId + "]";
	}
	
}
