package co.ipicorp.saas.core.model.dto;

import java.time.LocalDate;

import co.ipicorp.saas.core.model.CustomerType;
import grass.micro.apps.model.dto.SearchCondition;

/**
 * 
 * @author hienlt1
 *
 */
public class CustomerSearchCondition extends SearchCondition {

	private static final long serialVersionUID = 2894050078899746889L;

	private boolean enableName;
	private String name;

    private boolean enableEmail;
	private String email;

	private boolean enableCustomerType;
	private CustomerType customerType;

	private boolean enableCreateDate;
    private LocalDate fromDate;
    private LocalDate toDate;
	/**
	 * @return the enableName
	 */
	public boolean isEnableName() {
		return enableName;
	}
	/**
	 * @param enableName the enableName to set
	 */
	public void setEnableName(boolean enableName) {
		this.enableName = enableName;
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
	 * @return the enableCustomerType
	 */
	public boolean isEnableCustomerType() {
		return enableCustomerType;
	}
	/**
	 * @param enableCustomerType the enableCustomerType to set
	 */
	public void setEnableCustomerType(boolean enableCustomerType) {
		this.enableCustomerType = enableCustomerType;
	}
	/**
	 * @return the customerType
	 */
	public CustomerType getCustomerType() {
		return customerType;
	}
	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
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
		return "CustomerSearchCondition [enableName=" + enableName + ", name=" + name + ", enableEmail="
				+ enableEmail + ", email=" + email 
				+ ", enableCustomerType=" + enableCustomerType + ", customerType=" + customerType
				+ ", enableCreateDate=" + enableCreateDate + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

}
