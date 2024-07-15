/**
 * AccountModule.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.ipicorp.saas.core.model.util.AccountTypeConverter;
import grass.micro.apps.model.base.StatusLockAuditableEntity;

/**
 * AccountModule. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "td_account_module", uniqueConstraints = { @UniqueConstraint(columnNames = { "account_type", "account_id" }) })
public class AccountModule extends StatusLockAuditableEntity {
	
	private static final long serialVersionUID = 4775344106785677412L;

	@Column(name = "account_id", nullable = false, length = 11)
    private Integer accountId;

    @Column(name = "account_type", nullable = false)
    @Convert(converter = AccountTypeConverter.class)
    private AccountType accountType;

    @Column(name = "target_id", nullable = false, length = 11)
    private Integer targetId;

    @Column(name = "module_id", nullable = false, length = 11)
    private Integer moduleId;
    
    @Column(name = "customer_id", nullable = false, length = 11)
    private Integer customerId;
    
    /**
     * get value of <b>accountId</b>.
     * 
     * @return the accountId
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * Set value to <b>accountId</b>.
     * 
     * @param accountId
     *            the accountId to set
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * get value of <b>accountType</b>.
     * 
     * @return the accountType
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Set value to <b>accountType</b>.
     * 
     * @param accountType
     *            the accountType to set
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * get value of <b>targetId</b>.
     * 
     * @return the targetId
     */
    public Integer getTargetId() {
		return targetId;
	}

    /**
     * Set value to <b>targetId</b>.
     * 
     * @param targetId
     *            the targetId to set
     */
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	/**
     * get value of <b>moduleId</b>.
     * 
     * @return the moduleId
     */
	public Integer getModuleId() {
		return moduleId;
	}

	/**
     * Set value to <b>moduleId</b>.
     * 
     * @param moduleId
     *            the moduleId to set
     */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	/**
     * get value of <b>customerId</b>.
     * 
     * @return the customerId
     */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
     * Set value to <b>customerId</b>.
     * 
     * @param customerId
     *            the customerId to set
     */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
    public String toString() {
        return "AccountModule [accountId=" + accountId + ", accountType=" + accountType + ", targetId=" + targetId 
        		+ ", moduleId=" + moduleId + ", customerId=" + customerId + "]";
    }
}
