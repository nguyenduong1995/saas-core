/**
 * Staff.java
 * @copyright  Copyright © 2020 Vndata
 * @author     nguyeth
 * @version    1.0.0
 */
package co.ipicorp.saas.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import grass.micro.apps.model.base.Status;
import grass.micro.apps.model.base.StatusLockAuditableEntity;

/**
 * Staff. <<< Detail note.
 * 
 * @author nguyeth
 * @access public
 */
@Entity
@Table(name = "t_staff")
public class Staff extends StatusLockAuditableEntity implements Serializable {

    private static final long serialVersionUID = -7164222575385280619L;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

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

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "td_staff_role", joinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

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

    /**
     * get value of <b>roles</b>.
     * 
     * @return the roles
     */
    public List<Role> getRoles() {
        if (this.roles == null) {
            return new ArrayList<Role>();
        }
        
        return this.roles.stream().filter(role -> !role.getStatus().equals(Status.DELETED))
                .collect(Collectors.toList());
    }

    /**
     * Set value to <b>roles</b>.
     * 
     * @param roles
     *            the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
	public String toString() {
		return "User [account=" + account + ", fullname=" + fullname + ", address=" + address + ", mobile=" + mobile 
				+ ", telephone=" + telephone + ", telephoneExt=" + telephoneExt + ", roles=" + roles + "]";
	}

}
