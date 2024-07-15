package co.ipicorp.saas.core.model.dto;

import java.time.LocalDate;

import grass.micro.apps.model.base.Status;
import grass.micro.apps.model.dto.SearchCondition;

public class CustomerRegistrationSearchCondition extends SearchCondition {

	private static final long serialVersionUID = 28940501154746889L;

    private boolean enableEmail;
	private String email;

	private boolean enableTelephone;
	private String telephone;
	
	private boolean enableCompany;
	private Integer companyId;

	private boolean enableStatus;
	private Status status;


	private boolean enableCreateDate;
    private LocalDate fromDate;
    private LocalDate toDate;
	/**
	 * @return the enableEmail
	 */
	public boolean isEnableEmail() {
		return enableEmail;
	}
	/**
	 * @param enableEmail the enableEmail to set
	 */
	public void setEnableEmail(boolean enableEmail) {
		this.enableEmail = enableEmail;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the enableTelephone
	 */
	public boolean isEnableTelephone() {
		return enableTelephone;
	}
	/**
	 * @param enableTelephone the enableTelephone to set
	 */
	public void setEnableTelephone(boolean enableTelephone) {
		this.enableTelephone = enableTelephone;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the enableCompany
	 */
	public boolean isEnableCompany() {
		return enableCompany;
	}
	/**
	 * @param enableCompany the enableCompany to set
	 */
	public void setEnableCompany(boolean enableCompany) {
		this.enableCompany = enableCompany;
	}
	/**
	 * @return the company
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the enableStatus
	 */
	public boolean isEnableStatus() {
		return enableStatus;
	}
	/**
	 * @param enableStatus the enableStatus to set
	 */
	public void setEnableStatus(boolean enableStatus) {
		this.enableStatus = enableStatus;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the enableCreateDate
	 */
	public boolean isEnableCreateDate() {
		return enableCreateDate;
	}
	/**
	 * @param enableCreateDate the enableCreateDate to set
	 */
	public void setEnableCreateDate(boolean enableCreateDate) {
		this.enableCreateDate = enableCreateDate;
	}
	/**
	 * @return the fromDate
	 */
	public LocalDate getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public LocalDate getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerRegistrationSearchCondition [enableEmail=" + enableEmail + ", email=" + email
				+ ", enableTelephone=" + enableTelephone + ", telephone=" + telephone + ", enableCompany="
				+ enableCompany + ", companyId=" + companyId + ", enableStatus=" + enableStatus + ", status=" + status
				+ ", enableCreateDate=" + enableCreateDate + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
    
}
