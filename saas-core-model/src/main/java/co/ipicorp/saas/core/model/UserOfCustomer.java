/**
 * UserOfCustomer.java
 * @copyright  Copyright © 2020 Vndata
 * @author     ntduong
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import grass.micro.apps.model.base.StatusLockAuditableEntity;

/**
 * UserOfCustomer. <<< Detail note.
 * 
 * @author ntduong
 * @access public
 */
@Entity
@Table(name = "t_staff_of_customer")
public class UserOfCustomer extends StatusLockAuditableEntity implements Serializable {

	private static final long serialVersionUID = -4635735199863861057L;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

	@Column(name = "email", nullable = false, length = 255)
    private String email;
	
    @Column(name = "fullname", nullable = false, length = 255)
    private String fullname;
    
    @Column(name = "address", nullable = false, length = 1024)
    private String address;

    @Column(name = "mobile", nullable = false, length = 32)
    private String mobile;

    @Column(name = "tel", nullable = true, length = 32)
    private String telephone;

    @Column(name = "tel_ext", nullable = true, length = 8)
    private String telephoneExt;

	/**
     * get value of <b>account</b>.
     * 
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set value to <b>account</b>.
     * 
     * @param account
     *            the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * get value of <b>email</b>.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to <b>email</b>.
     * 
     * @param fullname
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * get value of <b>fullname</b>.
     * 
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Set value to <b>fullname</b>.
     * 
     * @param fullname
     *            the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * get value of <b>address</b>.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set value to <b>address</b>.
     * 
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get value of <b>mobile</b>.
     * 
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set value to <b>mobile</b>.
     * 
     * @param mobile
     *            the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * get value of <b>telephone</b>.
     * 
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set value to <b>telephone</b>.
     * 
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * get value of <b>telephoneExt</b>.
     * 
     * @return the telephoneExt
     */
    public String getTelephoneExt() {
        return telephoneExt;
    }

    /**
     * Set value to <b>telephoneExt</b>.
     * 
     * @param telephoneExt
     *            the telephoneExt to set
     */
    public void setTelephoneExt(String telephoneExt) {
        this.telephoneExt = telephoneExt;
    }

    @Override
	public String toString() {
		return "UserOfCustomer [account=" + account + ", email=" + email + ", fullname=" + fullname + ", address=" + address  
				+ ", mobile=" + mobile + ", telephone=" + telephone + ", telephoneExt=" + telephoneExt + "]";
	}

}
